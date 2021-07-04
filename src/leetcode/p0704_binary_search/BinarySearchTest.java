package leetcode.p0704_binary_search;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BinarySearchTest {
  @Test
  public void testSearch() {
    BinarySearch test = new BinarySearch();
    assertEquals(-1, test.search(new int[] {}, 1));
    assertEquals(0, test.search(new int[] {1}, 1));
    assertEquals(4, test.search(new int[] {0, 1, 2, 3, 4, 5, 6}, 4));
  }
}
