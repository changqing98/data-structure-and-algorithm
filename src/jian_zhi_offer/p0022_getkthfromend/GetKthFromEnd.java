package jian_zhi_offer.p0022_getkthfromend;

import common.ListNode;

public class GetKthFromEnd {
	public ListNode getKthFromEnd(ListNode head, int k) {
		ListNode fast = head, slow = head;
		for (int i = 0; i < k; i++) {
			if (fast != null) {
				fast = fast.next;
			} else {
				break;
			}
		}
		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
	}
}
