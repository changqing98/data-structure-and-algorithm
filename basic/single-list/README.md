# 玩转单链表

## 单链表结点数据结构

```java
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

	@Override
	public String toString() {
		return "ListNode{" +
			"val=" + val +
			", next=" + next +
			'}';
	}
}
```

## 1. 反转单链表

### 递归解法

1.  找递归出口：当前head为空或head为末尾结点时返回head
2.  递归求解head下一个结点 head.next 翻转的结果pre，pre即为反转后的链表首节点。
3.  对head 与 head.next 结点执行反转：
    1.  head的next结点的next指针指向head
    2.  head.next 指向null
4.  返回pre

```java
    public ListNode reverseByRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = ReverseList(head.next);
        head.next.next = head;
        head.next = null;
        return pre;
    }
```

### 非递归解法

1.  判断head为空或者head下一个结点为空直接返回head
2.  定义cur指针用于遍历整个单链表，初始指向head
3.  定义pre指针指向上一个遍历的结点，初始值为null
4.  开始遍历单链表：
    1.  定义next变量保存当前结点cur的下一个结点
    2.  cur的next指针指向上一个遍历的结点pre
    3.  pre指向当前结点cur
    4.  cur指向next
5.  当cur为null时，表示到达了链表末尾，此时pre则就表示原链表的末尾结点，同时表示反转后链表的首节点，直接返回pre

```java
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
```



## 2. 判断链表是否有环

### 快慢双指针

1.  定义慢指针slow、快指针fast
2.  遍历链表，慢指针每次前进一步，快指针每次前进二步
3.  若相遇则表示有环，返回true ; 若遍历到了链表尾部，则表示无环，返回false

```java
	public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
```



## 3. 寻找链表环的入口

```java
	public ListNode EntryNodeOfLoop(ListNode pHead) {
		if (pHead == null) {
			return null;
		}
		ListNode slow = pHead;
		ListNode fast = pHead;
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
		fast = pHead;
		while (fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
	}
```



### 单链表环的长度