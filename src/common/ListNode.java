package common;

public class ListNode {
  public int val;
  public ListNode next;

  public ListNode() {
  }

  public ListNode(int val) {
    this.val = val;
  }

  public ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  public static ListNode create() {
    ListNode node3 = new ListNode(3, null);
    ListNode node2 = new ListNode(2, node3);
    ListNode node1 = new ListNode(1, node2);
    ListNode node = new ListNode(0, node1);
    return node;
  }

  @Override
  public String toString() {
    return "ListNode{" + "val=" + val + ", next=" + next + '}';
  }
}
