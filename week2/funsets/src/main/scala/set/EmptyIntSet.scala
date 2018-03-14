package set

case object EmptyIntSet extends IntSet{
  override def incl(x: Int): IntSet = NonEmptyIntSet(x, EmptyIntSet, EmptyIntSet)

  override def contains(x: Int): Boolean = false

  override def union(other: IntSet): IntSet = other

  override def toString: String = " "
}
