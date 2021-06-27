#### [148. 排序链表](https://leetcode-cn.com/problems/sort-list/)



给你链表的头结点 `head` ，请将其按 **升序** 排列并返回 **排序后的链表** 。

**进阶：**

-   你可以在 `O(n log n)` 时间复杂度和常数级空间复杂度下，对链表进行排序吗？

 

**示例 1：**

![img](https://assets.leetcode.com/uploads/2020/09/14/sort_list_1.jpg)

```
输入：head = [4,2,1,3]
输出：[1,2,3,4]
```

**示例 2：**

![img](https://assets.leetcode.com/uploads/2020/09/14/sort_list_2.jpg)

```
输入：head = [-1,5,3,4,0]
输出：[-1,0,3,4,5]
```

**示例 3：**

```
输入：head = []
输出：[]
```

 

**提示：**

-   链表中节点的数目在范围 `[0, 5 * 104]` 内
-   `-105 <= Node.val <= 105`



## 题解

### 归并排序

1.  找到中间结点，并将链表从中间结点断开
2.  递归求解左边、右边的排序结果
3.  合并左、右边的排序结果

```java
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        while(fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        ListNode list1 = sortList(head);
        ListNode list2 = sortList(slow);
        ListNode result = new ListNode();
        ListNode cur = result;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        while(list1 != null){
            cur.next = list1;
            list1 = list1.next;
            cur = cur.next;
        }
        while(list2 != null){
            cur.next = list2;
            list2 = list2.next;
            cur = cur.next;
        }
        return result.next;
    }
```

