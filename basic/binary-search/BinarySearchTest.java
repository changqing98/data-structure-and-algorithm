import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BinarySearchTest {
  @Test
  public void testSearch() {
    BinarySearch test = new BinarySearch();
    assertEquals(-1, test.search(1, new int[] {}));
    assertEquals(0, test.search(1, new int[] { 1 }));
    assertEquals(4, test.search(4, new int[] { 0, 1, 2, 3, 4, 5, 6 }));
  }

  @Test
  public void testSearchLeftMost() {
    BinarySearch test = new BinarySearch();
    assertEquals(0, test.searchLeftMost(1, new int[] { 1 }));
    assertEquals(0, test.searchLeftMost(1, new int[] { 1, 1, 1, 1 }));
    assertEquals(4, test.searchLeftMost(4, new int[] { 0, 1, 2, 3, 4, 4, 4, 5, 6 }));
  }

  @Test
  public void testSearchRightMost() {
    BinarySearch test = new BinarySearch();
    assertEquals(3, test.searchRightMost(1, new int[] { 1, 1, 1, 1 }));
    assertEquals(-1, test.searchRightMost(3, new int[] { 2, 2 }));
    assertEquals(4, test.searchRightMost(3, new int[] { 0, 3, 3, 3, 3, 4, 5, 6 }));
  }
}
