package leetcode.p0129_sum_root_to_leaf_numbers;

import static org.junit.Assert.assertEquals;

import common.TreeNode;
import org.junit.Test;

public class SumRootToLeafNumbersTest {

  @Test
  public void sumNumbers() {
    TreeNode node1 = new TreeNode(4);
    TreeNode node2 = new TreeNode(9);
    node1.left = node2;
    node1.right = new TreeNode(0);
    node2.left = new TreeNode(5);
    node2.right = new TreeNode(1);
    SumRootToLeafNumbers demo = new SumRootToLeafNumbers();
    assertEquals(1026, demo.sumNumbers(node1));
  }
}
