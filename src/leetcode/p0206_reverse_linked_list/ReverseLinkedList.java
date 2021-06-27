package leetcode.p0206_reverse_linked_list;

import common.ListNode;

public class ReverseLinkedList {
  public ListNode reverse(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode cur = head;
    ListNode pre = null;
    while (cur != null) {
      ListNode next = cur.next;
      cur.next = pre;
      pre = cur;
      cur = next;
    }
    return pre;
  }

  public ListNode reverseByRecursion(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode pre = reverse(head.next);
    head.next.next = head;
    head.next = null;
    return pre;
  }
}
