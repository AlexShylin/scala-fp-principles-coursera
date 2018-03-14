trait Expr {
  def eval: Int = this match {
    case Number(n) => n
    case Sum(arg1, arg2) => arg1.eval + arg2.eval
    case Prod(arg1, arg2) => arg1.eval * arg2.eval
    case Var(_, value) => value.n
  }

  def show: Unit = this match {
    case Number(n) => print(n)
    case Sum(arg1, arg2) => {
      if (arg1.priority > priority) paretheses(arg1) else arg1.show
      print(" + ")
      if (arg2.priority > priority) paretheses(arg2) else arg2.show
    }
    case Prod(arg1, arg2) => {
      if (arg1.priority > priority) paretheses(arg1) else arg1.show
      print(" * ")
      if (arg2.priority > priority) paretheses(arg2) else arg2.show
    }
    case Var(name, _) => print(name)
  }

  def priority: Int

  def paretheses(expr: Expr): Unit = {
    print("(")
    expr.show
    print(")")
  }
}

case class Number(n: Int) extends Expr {
  override def priority: Int = 0
}

case class Sum(arg1: Expr, arg2: Expr) extends Expr {
  def apply(arg1: Int, arg2: Expr) = Sum(Number(arg1), arg2)

  def apply(arg1: Expr, arg2: Int) = Sum(arg1, Number(arg2))

  override def priority: Int = 2
}

case class Prod(arg1: Expr, arg2: Expr) extends Expr {
  def apply(arg1: Int, arg2: Expr) = Prod(Number(arg1), arg2)

  def apply(arg1: Expr, arg2: Int) = Prod(arg1, Number(arg2))

  override def priority: Int = 1
}

case class Var(name: String, value: Number) extends Expr {
  override def priority: Int = 0
}

object Sum {
  def apply(arg1: Int, arg2: Expr) = new Sum(Number(arg1), arg2)

  def apply(arg1: Expr, arg2: Int) = new Sum(arg1, Number(arg2))
}

object Prod {
  def apply(arg1: Int, arg2: Expr) = new Prod(Number(arg1), arg2)

  def apply(arg1: Expr, arg2: Int) = new Prod(arg1, Number(arg2))
}

Prod(Sum(2, Var("x", Number(2))), Var("y", Number(2))).show
Sum(Prod(2, Var("x", Number(1))), Var("y", Number(1))).show