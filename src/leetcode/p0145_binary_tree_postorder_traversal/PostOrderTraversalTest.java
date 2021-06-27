package leetcode.p0145_binary_tree_postorder_traversal;

import static org.junit.Assert.assertArrayEquals;

import common.TreeNode;
import java.util.List;
import org.junit.Test;

public class PostOrderTraversalTest {

  @Test
  public void test() {
    TreeNode root = TreeNode.create();
    PostOrderTraversal test = new PostOrderTraversal();
    List<Integer> result = test.postorderTraversal(root);
    assertArrayEquals(new Integer[] {4, 5, 2, 6, 3, 1}, result.toArray(new Integer[] {}));
  }
}
