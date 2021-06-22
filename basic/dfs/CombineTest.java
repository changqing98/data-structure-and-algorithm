import static org.junit.Assert.assertEquals;

import java.util.List;
import org.junit.Test;

public class CombineTest {
  @Test
  public void test() {
    Combine inst = new Combine();
    List<int[]> result = inst.combine(new int[] {1, 2, 3, 4, 5}, 10);
    assertEquals(10, result.size());
    for (int[] item : result) {
      for (Integer x : item) {
        System.out.print(x + " ");
      }
      System.out.println();
    }
  }
}
