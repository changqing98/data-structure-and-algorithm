import java.util.List;
import org.junit.Test;

public class PermutationsTest {
  @Test
  public void test() {
    Permutations demo = new Permutations();
    List<List<Integer>> result = demo.permute(new int[] {1, 2, 3});
    for (List<Integer> item : result) {
      for (Integer x : item) {
        System.out.print(x + " ");
      }
      System.out.println();
    }
  }
}
