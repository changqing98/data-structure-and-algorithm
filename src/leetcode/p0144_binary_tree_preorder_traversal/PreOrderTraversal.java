package leetcode.p0144_binary_tree_preorder_traversal;

import common.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal {
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Stack<TreeNode> stack = new Stack<>();
    while (root != null || !stack.isEmpty()) {
      while (root != null) {
        result.add(root.val);
        stack.add(root);
        root = root.left;
      }
      root = stack.pop();
      root = root.right;
    }
    return result;
  }
}
