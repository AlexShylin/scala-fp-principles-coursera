import scala.annotation.tailrec

object Test {

  def uniqueComb(seq: List[Char], len: Int): List[List[Char]] = {
    lazy val seqCut = seq.take(len)

    @tailrec
    def loop(prevCombs: List[List[Char]]): List[List[Char]] =
      if (prevCombs.forall(_.length == len)) prevCombs
      else loop(for (x <- prevCombs; e <- seqCut) yield e :: x)

    loop(seqCut.map(List(_)))
  }

  def main(args: Array[String]): Unit = {
    val seq = List('1', '2', '3', 'a', 'b', 'c')
    println(uniqueComb(seq, 4))
  }
}
