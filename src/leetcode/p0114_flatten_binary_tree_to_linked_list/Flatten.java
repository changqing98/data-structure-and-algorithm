package leetcode.p0114_flatten_binary_tree_to_linked_list;

import common.TreeNode;

public class Flatten {
  TreeNode prev;

  public void flatten(TreeNode root) {
    if (root == null) {
      return;
    }
    flatten(root.right);
    flatten(root.left);
    root.left = null;
    root.right = prev;
    prev = root;
  }
}
