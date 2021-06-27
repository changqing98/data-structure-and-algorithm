package leetcode.p0104_maximum_depth_of_binary_tree;

import common.TreeNode;

public class MaximunDepthOfBinaryTree {
  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
  }
}
