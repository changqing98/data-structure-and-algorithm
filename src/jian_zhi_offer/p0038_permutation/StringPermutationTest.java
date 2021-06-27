package jian_zhi_offer.p0038_permutation;

import org.junit.Test;

public class StringPermutationTest {

  @Test
  public void test() {
    StringPermutation test = new StringPermutation();
    String[] result = test.permutation("asd");
    for (String str : result) {
      System.out.println(str);
    }
  }
}
