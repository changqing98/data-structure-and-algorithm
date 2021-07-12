package leetcode.p0082_remove_duplicates_from_sorted_list_ii;

import common.ListNode;

public class DeleteDuplicates {
  public ListNode deleteDuplicates(ListNode head) {
    if(head == null || head.next == null){
      return head;
    }
    ListNode result = new ListNode(-1);
    result.next = head;
    ListNode cur = result;
    while(cur.next != null && cur.next.next != null){
      if(cur.next.val == cur.next.next.val){
        int val = cur.next.val;
        while(cur.next != null && cur.next.val == val){
          cur.next = cur.next.next;
        }
      }else {
        cur = cur.next;
      }
    }
    return result.next;
  }
}
