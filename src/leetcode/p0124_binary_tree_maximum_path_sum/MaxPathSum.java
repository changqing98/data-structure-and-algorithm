package leetcode.p0124_binary_tree_maximum_path_sum;

import common.TreeNode;

public class MaxPathSum {
  int max = Integer.MIN_VALUE;

  public int maxPathSum(TreeNode root) {
    dfs(root);
    return max;
  }

  public int dfs(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = Math.max(dfs(root.left), 0);
    int right = Math.max(dfs(root.right), 0);
    int result = left + right + root.val;
    max = Math.max(max, result);
    return Math.max(left, right) + root.val;
  }
}
