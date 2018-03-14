package recfun

import scala.annotation.tailrec

object Main extends App {

  /**
    * Exercise 1
    */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0) 1
    else if (c > r || c < 0) 0
    else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
    * Exercise 2
    */
  def balance(str: List[Char]): Boolean = {
    val filteredString = str.filter(p => p == '(' || p == ')')

    @tailrec
    def loop(acc: Int, slicedString: List[Char]): Int = {
      if (slicedString.isEmpty || acc < 0) acc
      else if (slicedString.head == '(') loop(acc + 1, slicedString.drop(1))
      else loop(acc - 1, slicedString.drop(1))
    }

    loop(0, filteredString) == 0
  }

  /**
    * Exercise 3
    */
  def countChange(money: Int, coins: List[Int]): Int =
    if (money < 0 || coins.isEmpty) 0
    else if (money == 0) 1
    else countChange(money - coins.head, coins) +
      countChange(money, coins.tail)


  /* General exercises */

  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int = {
    @tailrec
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a + 1, combine(acc, f(a)))
    }

    loop(a, zero)
  }

  def product(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, _ * _, 1)(a, b)

  def factorial(n: Int): Int = product(x => x)(1, n)

  println(product(x => x * x)(3, 4))
  println(factorial(5))
}
