package nat

/**
  * Represent the natural number that's one bigger than the argument
  *
  * @param n previous number
  */
class Succ(n: Nat) extends Nat {
  override def isZero: Boolean = false

  /**
    * A positive natural number, the one before that, throws an exception if the natural number is zero
    *
    * @return one before that
    * @throws UnsupportedOperationException if zero
    */
  override def predecessor: Nat = n

  override def +(that: Nat): Nat = if (that == Zero) this else this.successor + that.predecessor

  override def -(that: Nat): Nat = if (that == Zero) this else this.predecessor - that.predecessor
}