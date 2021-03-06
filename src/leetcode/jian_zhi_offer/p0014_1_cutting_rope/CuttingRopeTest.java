package leetcode.jian_zhi_offer.p0014_1_cutting_rope;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CuttingRopeTest {

  @Test
  public void test() {
    CuttingRope inst = new CuttingRope();
    assertEquals(1, inst.cuttingRopeByDP(2));
    assertEquals(36, inst.cuttingRopeByDP(10));
  }

  @Test
  public void testGreedy() {
    CuttingRope inst = new CuttingRope();
    assertEquals(1, inst.cuttingRopeByGreedy(2));
    assertEquals(36, inst.cuttingRopeByGreedy(10));
  }

}
