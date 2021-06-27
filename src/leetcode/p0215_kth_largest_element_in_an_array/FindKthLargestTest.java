import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FindKthLargestTest {

  @Test
  public void test1() {
    FindKthLargest test = new FindKthLargest();
    assertEquals(1, test.findKthLargest(new int[] {2, 1}, 2));
    assertEquals(4, test.findKthLargest(new int[] {3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    assertEquals(5, test.findKthLargest(new int[] {3, 2, 1, 5, 6, 4}, 2));
  }
}
