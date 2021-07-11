package leetcode.p0226_invert_binary_tree;

import common.TreeNode;
import java.util.Stack;

/**
 * 翻转二叉树
 * 镜像二叉树
 *
 * @see <a href="https://leetcode-cn.com/problems/invert-binary-tree">leetcode</a>
 */
public class InvertBinaryTree {

  /**
   * 非递归dfs
   * 类似数的非递归先序遍历，按先序依次交换左右节点
   */
  public TreeNode invertTreeNonRecursiveDfs(TreeNode root) {
    if (root == null) {
      return null;
    }
    TreeNode result = root;
    Stack<TreeNode> stack = new Stack<>();
    while (root != null || !stack.isEmpty()) {
      while (root != null) {
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        stack.add(root);
        root = root.left;
      }
      root = stack.pop();
      root = root.right;
    }
    return result;
  }

  /**
   * 递归
   */
  public TreeNode invertTreeDfs(TreeNode root) {
    if (root == null) {
      return null;
    }
    TreeNode tmp = invertTreeDfs(root.left);
    root.left = invertTreeDfs(root.right);
    root.right = tmp;
    return root;
  }
}
