import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class TestJava {

/*
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
*/

    public static List<List<Character>> uniqueComb(List<Character> seq, int len) {
        List<Character> seqCut = seq.subList(0, len);
        return loop(seqCut.stream().map(Arrays::asList).collect(Collectors.toList()), seqCut);
    }

    public static List<List<Character>> loop(List<List<Character>> prevCombs, List<Character> seq) {
        if (prevCombs.stream().allMatch(characters -> characters.size() == seq.size())) {
            return prevCombs;
        } else {
            List<List<Character>> newCombs = new LinkedList<>();
            for (List<Character> l : prevCombs) {
                for (Character e : seq) {
                    List<Character> newComb = new LinkedList<>();
                    newComb.add(e);
                    newComb.addAll(l);
                    newCombs.add(newComb);
                }
            }
            return loop(newCombs, seq);
        }
    }

    public static void main(String[] args) {
        System.out.println(uniqueComb(Arrays.asList('1', '2', '3', 'a', 'b', 'c'), 4).size());
    }
}
