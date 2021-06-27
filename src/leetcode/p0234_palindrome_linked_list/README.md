#### [234. 回文链表](https://leetcode-cn.com/problems/palindrome-linked-list/)

难度简单983

请判断一个链表是否为回文链表。

**示例 1:**

```
输入: 1->2
输出: false
```

**示例 2:**

```
输入: 1->2->2->1
输出: true
```



## 题解

### 双指针

1. 遍历链表，使用快慢指针找到链表中点，遍历的过程中对前一半链表进行反转
2. 遍历完成后如果快指针为空，表示链表节点个数为单数，slow指针此时指在中间结点位置，因此slow指针需要右移一个节点，让其指向右半截链表的首节点
3. 此时可以已经找到前半截链表与后半截链表的首节点，依次比较每一个节点的值

```java
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
```

