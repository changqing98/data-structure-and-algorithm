package leetcode.p0095_unique_binary_search_trees2;

import common.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTrees2 {
  public List<TreeNode> generateTrees(int n) {
    if (n == 0) {
      return new ArrayList<>();
    }
    return generate(1, n);
  }

  public List<TreeNode> generate(int start, int end) {
    List<TreeNode> result = new ArrayList<>();
    if (start > end) {
      result.add(null);
      return result;
    }
    for (int i = start; i <= end; i++) {
      List<TreeNode> allLeftTreeNodes = generate(start, i - 1);
      List<TreeNode> allRightTreeNodes = generate(i + 1, end);
      for (TreeNode leftNode : allLeftTreeNodes) {
        for (TreeNode rightNode : allRightTreeNodes) {
          TreeNode root = new TreeNode(i);
          root.left = leftNode;
          root.right = rightNode;
          result.add(root);
        }
      }
    }
    return result;
  }
}
