package leetcode.p0450_delete_node_in_a_bst;

import common.TreeNode;

public class DeleteNode {
  private int next(TreeNode node) {
    node = node.right;
    while (node.left != null) {
      node = node.left;
    }
    return node.val;
  }

  private int pre(TreeNode node) {
    node = node.left;
    while (node.right != null) {
      node = node.right;
    }
    return node.val;
  }

  public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) {
      return root;
    }
    if (root.val < key) {
      root.right = deleteNode(root.right, key);
    } else if (root.val > key) {
      root.left = deleteNode(root.left, key);
    } else {
      if (root.left == null && root.right == null) {
        root = null;
      } else if (root.right != null) {
        root.val = next(root);
        root.right = deleteNode(root.right, root.val);
      } else {
        root.val = pre(root);
        root.left = deleteNode(root.left, root.val);
      }
    }
    return root;
  }
}
