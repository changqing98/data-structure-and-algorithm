#### [剑指 Offer 22. 链表中倒数第k个节点](https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/)

难度简单169

输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。

例如，一个链表有 `6` 个节点，从头节点开始，它们的值依次是 `1、2、3、4、5、6`。这个链表的倒数第 `3` 个节点是值为 `4` 的节点。

 

**示例：**

```
给定一个链表: 1->2->3->4->5, 和 k = 2.

返回链表 4->5.
```



## 题解

### 快慢双指针

1.  快指针先走k步，如果快指针指向null，则证明已到达末尾结点，且长度超出了k
2.  启动慢指针，同时向前遍历，直到快指针指向null，则慢指针指向的即为倒数第k个结点

```java
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
```

