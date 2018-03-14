package set

object Main {
  //  def main(args: Array[String]): Unit = {
  //    val s1 = NonEmptyIntSet(5, EmptyIntSet, EmptyIntSet)
  //    val s2 = s1.incl(4).incl(7).incl(2).incl(6).incl(9).incl(1).incl(3).union(NonEmptyIntSet(8, EmptyIntSet, EmptyIntSet).incl(10))
  //    println(s2)
  //  }

  def main(args: Array[String]): Unit = {
    def list: List[Int] = 0 :: 1 :: 2 :: 3 :: 4 :: 5 :: 6 :: Nil

    println(nth(2, list))
    println(nth(-1, list))
  }

  def nth(n: Int, list: List[Int]): Int = {
    if (list.isEmpty) throw new IndexOutOfBoundsException
    else if (n != 0) nth(n - 1, list.tail)
    else list.head
  }
}
