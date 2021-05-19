import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class PalindromeLinkedListTest {

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        PalindromeLinkedList test = new PalindromeLinkedList();
        assertFalse(test.isPalindrome(head));
    }

}
