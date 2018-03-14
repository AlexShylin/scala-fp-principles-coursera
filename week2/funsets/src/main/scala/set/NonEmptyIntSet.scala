package set

case class NonEmptyIntSet(curr: Int, left: IntSet, right: IntSet) extends IntSet {


  override def incl(x: Int): IntSet = {
    if (x < curr) NonEmptyIntSet(curr, left incl x, right)
    else if (x > curr) NonEmptyIntSet(curr, left, right incl x)
    else this
  }

  override def contains(x: Int): Boolean = {
    if (x < curr) left contains x
    else if (x > curr) right contains x
    else true
  }

  override def union(other: IntSet): IntSet = {
    left union (right union (other incl curr))
  }

  override def toString: String = left.toString + curr + right
}
