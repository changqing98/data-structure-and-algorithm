## 1. 反转单链表

### 递归解法

1. 找递归出口：当前 head 为空或 head 为末尾结点时返回 head
2. 递归求解 head 下一个结点 head.next 翻转的结果 pre，pre 即为反转后的链表首节点。
3. 对 head 与 head.next 结点执行反转：
   1. head 的 next 结点的 next 指针指向 head
   2. head.next 指向 null
4. 返回 pre

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

1. 判断 head 为空或者 head 下一个结点为空直接返回 head
2. 定义 cur 指针用于遍历整个单链表，初始指向 head
3. 定义 pre 指针指向上一个遍历的结点，初始值为 null
4. 开始遍历单链表：
   1. 定义 next 变量保存当前结点 cur 的下一个结点
   2. cur 的 next 指针指向上一个遍历的结点 pre
   3. pre 指向当前结点 cur
   4. cur 指向 next
5. 当 cur 为 null 时，表示到达了链表末尾，此时 pre 则就表示原链表的末尾结点，同时表示反转后链表的首节点，直接返回 pre

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
