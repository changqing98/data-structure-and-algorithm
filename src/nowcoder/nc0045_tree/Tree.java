package nowcoder.nc0045_tree;

import common.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Tree {

  public int[][] threeOrders(TreeNode root) {
    return new int[][] {pre(root), mid(root), post(root)};
  }

  public int[] pre(TreeNode node) {
    List<Integer> result = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    while (node != null || !stack.isEmpty()) {
      while (node != null) {
        result.add(node.val);
        stack.push(node);
        node = node.left;
      }
      node = stack.pop();
      node = node.right;
    }
    return result.stream().mapToInt(x -> x).toArray();
  }

  public int[] mid(TreeNode node) {
    List<Integer> result = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    while (node != null || !stack.isEmpty()) {
      while (node != null) {
        stack.push(node);
        node = node.left;
      }
      node = stack.pop();
      result.add(node.val);
      node = node.right;
    }
    return result.stream().mapToInt(x -> x).toArray();
  }

  public int[] post(TreeNode node) {
    List<Integer> result = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode pre = null;
    while (node != null || !stack.isEmpty()) {
      while (node != null) {
        stack.push(node);
        node = node.left;
      }
      node = stack.pop();
      if (node.right == null || node.right == pre) {
        result.add(node.val);
        pre = node;
        node = null;
      } else {
        stack.add(node);
        node = node.right;
      }
    }
    return result.stream().mapToInt(x -> x).toArray();
  }
}
