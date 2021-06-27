package leetcode.p0102_binarytreelevelordertraversal;

import common.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      List<Integer> item = new ArrayList<>();
      int size = queue.size();
      for (int i = 1; i <= size; i++) {
        TreeNode rm = queue.poll();
        item.add(rm.val);
        if (rm.left != null) {
          queue.add(rm.left);
        }
        if (rm.right != null) {
          queue.add(rm.right);
        }
      }
      result.add(item);
    }
    return result;
  }
}
