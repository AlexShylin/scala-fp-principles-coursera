package patmat

import scala.io.Source

object test {

  val in = Source.fromURL("https://lamp.epfl.ch/files/content/sites/lamp/files/teaching/progfun/linuxwords.txt")
  val words = in.getLines.toSeq.filter(_.forall(_.isLetter))

  val mnem = Map('2' -> "ABC", '3' -> "DEF",
    '4' -> "GHI", '5' -> "JKL", '6' -> "MNO",
    '7' -> "PQRS", '8' -> "TUV", '9' -> "WXYZ")


  def charCode: Map[Char, Char] =
    mnem.flatMap { case ((num, chars)) => for (char <- chars) yield (char, num) }

  def wordCode(word: String): String = word.toUpperCase map charCode

  def wordsForNum: Map[String, Seq[String]] = (words groupBy wordCode) withDefaultValue Seq()

  lazy val wordsTable: Map[String, Seq[String]] = wordsForNum

  def getAllSubstrings(numericPhrase: String): Set[String] = {
    if (numericPhrase.isEmpty) Set()
    else if (numericPhrase.length == 1) Set(numericPhrase)
    else getAllSubstrings(numericPhrase.tail) ++ getAllSubstrings(numericPhrase.init) + numericPhrase
  }

  def encode(numericPhrase: String): Set[List[String]] = {

  }

  def main(args: Array[String]): Unit = {
    println(encode("7225247386"))
    //    println(wordsForNum("2"))
  }
}