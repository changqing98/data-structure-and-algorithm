import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagLevelOrder {

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    List<List<Integer>> result = new ArrayList<>();
    int row = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      Deque<Integer> item = new LinkedList<>();
      while (size != 0) {
        TreeNode node = queue.poll();
        if (row % 2 == 0) {
          item.offerLast(node.val);
        } else {
          item.offerFirst(node.val);
        }
        if (node.left != null) {
          queue.offer(node.left);
        }
        if (node.right != null) {
          queue.offer(node.right);
        }
        size--;
      }
      row++;
      result.add(new ArrayList(item));
    }
    return result;
  }

}
