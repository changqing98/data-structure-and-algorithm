public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    public ListNode removeElements2(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return head;
        }
        ListNode cur = head.next;
        ListNode result = head;
        ListNode pre = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
                cur.next = null;
            }
            pre = cur;
            cur = cur.next;
        }
        return result;
    }
}
