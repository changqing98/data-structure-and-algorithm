package leetcode.p0142_linked_list_cycle_ii;

import common.ListNode;

public class DetectCycle {
  public ListNode detectCycle(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode slow = head;
    ListNode fast = head;
    boolean hasCycle = false;
    // 首先判断是否有环
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        hasCycle = true;
        break;
      }
    }
    // 如果没有环直接返回null
    if (!hasCycle) {
      return null;
    }
    // 当两个指针在环上相遇，将其中一个指针指向头节点，另一个继续呆在相遇点，然后两个指针继续向前遍历，下次相遇点就是环的入口
    fast = head;
    while (fast != slow) {
      fast = fast.next;
      slow = slow.next;
    }
    return slow;
  }
}
