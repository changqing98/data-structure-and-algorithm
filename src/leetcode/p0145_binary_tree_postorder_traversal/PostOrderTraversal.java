package leetcode.p0145_binary_tree_postorder_traversal;

import common.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {
  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Stack<TreeNode> stack = new Stack<>();
    TreeNode pre = null;
    while (root != null || !stack.isEmpty()) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
      root = stack.pop();
      if (root.right == null || root.right == pre) {
        result.add(root.val);
        pre = root;
        root = null;
      } else {
        stack.push(root);
        root = root.right;
      }
    }
    return result;
  }
}
