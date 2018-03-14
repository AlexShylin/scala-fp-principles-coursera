package nat

object Main extends App {
  val one = Zero.successor
  val two = one.successor
  val three = one + two
  assert(three.predecessor.predecessor.predecessor == Zero)
}
