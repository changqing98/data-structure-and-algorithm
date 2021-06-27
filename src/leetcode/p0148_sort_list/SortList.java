package leetcode.p0148_sort_list;

import common.ListNode;

public class SortList {
  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode slow = head;
    ListNode fast = head;
    ListNode pre = null;
    while (fast != null && fast.next != null) {
      pre = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
    pre.next = null;
    ListNode list1 = sortList(head);
    ListNode list2 = sortList(slow);
    ListNode result = new ListNode();
    ListNode cur = result;
    while (list1 != null && list2 != null) {
      if (list1.val < list2.val) {
        cur.next = list1;
        list1 = list1.next;
      } else {
        cur.next = list2;
        list2 = list2.next;
      }
      cur = cur.next;
    }

    while (list1 != null) {
      cur.next = list1;
      list1 = list1.next;
      cur = cur.next;
    }
    while (list2 != null) {
      cur.next = list2;
      list2 = list2.next;
      cur = cur.next;
    }
    return result.next;
  }
}
