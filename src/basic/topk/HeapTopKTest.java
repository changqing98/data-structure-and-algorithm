package basic.topk;

import java.util.Arrays;
import org.junit.Test;

public class HeapTopKTest {

  @Test
  public void listTopK() {
    int[] array = new int[] {1, 4, 5, 7, 9, 2, 3, 4};
    HeapTopK test = new HeapTopK();
    int[] result = test.listTopK(array, 4);
    System.out.print(Arrays.toString(result));
  }
}
