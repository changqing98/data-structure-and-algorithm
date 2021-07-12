package leetcode.p0083_remove_duplicates_from_sorted_list;

import common.ListNode;

public class DeleteDuplicates {
  public ListNode deleteDuplicates(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode cur = head;
    while (cur.next != null) {
      if (cur.val == cur.next.val) {
        cur.next = cur.next.next;
      } else {
        cur = cur.next;
      }
    }
    return head;
  }
}
