package leetcode.p0109_convert_sorted_list_to_binary_search_tree;

import common.ListNode;
import common.TreeNode;

public class SortedListToBST {
  public TreeNode sortedListToBST(ListNode head) {
    if (head == null) {
      return null;
    }
    if (head.next == null) {
      return new TreeNode(head.val);
    }
    ListNode slow = head;
    ListNode fast = head;
    ListNode pre = null;
    while (fast != null && fast.next != null) {
      pre = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
    TreeNode root = new TreeNode(slow.val);
    pre.next = null;
    root.left = sortedListToBST(head);
    root.right = sortedListToBST(slow.next);
    return root;
  }
}
