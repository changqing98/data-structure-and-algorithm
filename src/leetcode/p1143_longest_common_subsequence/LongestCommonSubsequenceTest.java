package leetcode.p1143_longest_common_subsequence;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LongestCommonSubsequenceTest {
  @Test
  public void test() {
    LongestCommonSubsequence inst = new LongestCommonSubsequence();
    assertEquals(3, inst.longestCommonSubsequence("abcde", "ace"));
    assertEquals(3, inst.longestCommonSubsequence("abc", "abc"));
    assertEquals(0, inst.longestCommonSubsequence("abc", "def"));
  }

}
