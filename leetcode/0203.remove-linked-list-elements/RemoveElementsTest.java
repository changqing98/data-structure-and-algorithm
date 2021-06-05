import org.junit.Test;

public class RemoveElementsTest {

    @Test
    public void test() {
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        node2.next = node3;
        ListNode node1 = new ListNode(1);
        node1.next = node2;

        RemoveElements test = new RemoveElements();
        test.removeElements2(node1, 3);
    }

}
