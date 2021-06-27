package leetcode.p0234_palindrome_linked_list;

import static org.junit.Assert.assertFalse;

import common.ListNode;
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
