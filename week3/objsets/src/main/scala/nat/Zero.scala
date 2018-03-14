package nat

object Zero extends Nat {
  override def isZero: Boolean = true

  /**
    * A positive natural number, the one before that, throws an exception if the natural number is zero
    *
    * @return one before that
    * @throws UnsupportedOperationException if zero
    */
  override def predecessor: Nat = throw new NoSuchElementException

  override def +(that: Nat): Nat = that

  override def -(that: Nat): Nat = if (that.isZero) that else throw new NoSuchElementException
}
