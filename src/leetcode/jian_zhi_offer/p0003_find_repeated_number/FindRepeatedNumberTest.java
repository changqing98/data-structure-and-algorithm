package leetcode.jian_zhi_offer.p0003_find_repeated_number;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FindRepeatedNumberTest {
  @Test
  public void test() {
    FindRepeatedNumber test = new FindRepeatedNumber();
    assertEquals(5, test.findRepeatNumber(new int[] {1, 2, 3, 4, 5, 6, 5, 8, 9}));
  }
}
