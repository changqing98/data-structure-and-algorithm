package leetcode.jian_zhi_offer.p0068_1_lowest_common_ancestor;

import common.TreeNode;

public class BSTLowestCommonAncestor {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    while (root != null) {
      if (root.val > p.val && root.val > q.val) {
        root = root.left;
      } else if (root.val < p.val && root.val < q.val) {
        root = root.right;
      } else {
        break;
      }
    }
    return root;
  }

  public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
    if (p.val > q.val) {
      TreeNode tmp = p;
      p = q;
      q = tmp;
    }
    while (root != null) {
      if (root.val > q.val) {
        root = root.left;
      } else if (root.val < p.val) {
        root = root.right;
      } else {
        break;
      }
    }
    return root;
  }
}
