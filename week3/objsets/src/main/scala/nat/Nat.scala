package nat

abstract class Nat {
  def isZero: Boolean

  /**
    * A positive natural number, the one before that, throws an exception if the natural number is zero
    * @return one before that
    * @throws UnsupportedOperationException if zero
    */
  def predecessor: Nat


  /**
    * Gives the next natural number after the current natural number.
    * @return the next natural number
    */
  def successor: Nat = new Succ(this)

  def +(that: Nat): Nat

  def -(that: Nat): Nat

}