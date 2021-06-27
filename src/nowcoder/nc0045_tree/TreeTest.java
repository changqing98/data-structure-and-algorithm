package nowcoder.nc0045_tree;

import common.TreeNode;
import org.junit.Test;

public class TreeTest {

  @Test
  public void test() {
    TreeNode root = TreeNode.create();
    Tree test = new Tree();
    int[][] result = test.threeOrders(root);
    System.out.println(result);
  }

}
