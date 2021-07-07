package leetcode.p0025_reverse_nodes_in_k_group;

import common.ListNode;

public class ReverseNodesInKGroup {
  public ListNode reverseKGroup(ListNode head, int k) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode tail = head;
    for (int i = 0; i < k; i++) {
      if (tail == null) {
        return head;
      }
      tail = tail.next;
    }
    ListNode cur = head;
    ListNode next;
    ListNode pre = null;
    while (cur != tail) {
      next = cur.next;
      cur.next = pre;
      pre = cur;
      cur = next;
    }
    head.next = reverseKGroup(tail, k);
    return pre;
  }
}
