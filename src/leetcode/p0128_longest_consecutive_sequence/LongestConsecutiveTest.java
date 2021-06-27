import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LongestConsecutiveTest {

  @Test
  public void test() {
    LongestConsecutive test = new LongestConsecutive();
    assertEquals(4, test.longestConsecutive(new int[] {100, 4, 200, 1, 3, 2}));
  }
}
