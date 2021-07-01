package leetcode.p0559_maximum_depth_of_n_ary_tree;

import java.util.List;


public class MaxDepth {
  public int maxDepth(Node root) {
    if (root == null) {
      return 0;
    }
    if (root.children == null || root.children.isEmpty()) {
      return 1;
    }
    int max = 0;
    for (Node node : root.children) {
      max = Math.max(max, maxDepth(node) + 1);
    }
    return max;
  }

  class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, List<Node> _children) {
      val = _val;
      children = _children;
    }
  }
}

