public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode newHead = head;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            newHead = slow;
            slow = slow.next;
            fast = fast.next.next;
            newHead.next = pre;
            pre = newHead;
        }
        if (fast != null) {
            slow = slow.next;
        }
        while (slow != null && newHead != null) {
            if (slow.val != newHead.val) {
                return false;
            }
            slow = slow.next;
            newHead = newHead.next;
        }
        return true;
    }
}