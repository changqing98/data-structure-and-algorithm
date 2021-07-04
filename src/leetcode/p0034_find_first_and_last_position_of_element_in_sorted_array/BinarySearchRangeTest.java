package leetcode.p0034_find_first_and_last_position_of_element_in_sorted_array;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class BinarySearchRangeTest {

  @Test
  public void test() {
    BinarySearchRange test = new BinarySearchRange();
    assertArrayEquals(new int[] {3, 4}, test.searchRange(new int[] {5, 7, 7, 8, 8, 10}, 8));
    assertArrayEquals(new int[] {-1, -1}, test.searchRange(new int[] {5, 7, 7, 8, 8, 10}, 6));
    assertArrayEquals(new int[] {-1, -1}, test.searchRange(new int[] {}, 0));
  }

}
