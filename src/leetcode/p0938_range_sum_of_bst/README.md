#### [938. 二叉搜索树的范围和](https://leetcode-cn.com/problems/range-sum-of-bst/)

难度简单214

给定二叉搜索树的根结点 `root`，返回值位于范围 *`[low, high]`* 之间的所有结点的值的和。

 

**示例 1：**

![img](https://assets.leetcode.com/uploads/2020/11/05/bst1.jpg)

```
输入：root = [10,5,15,3,7,null,18], low = 7, high = 15
输出：32
```

**示例 2：**

![img](https://assets.leetcode.com/uploads/2020/11/05/bst2.jpg)

```
输入：root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
输出：23
```

 

**提示：**

-   树中节点数目在范围 `[1, 2 * 104]` 内
-   `1 <= Node.val <= 105`
-   `1 <= low <= high <= 105`
-   所有 `Node.val` **互不相同**



## 题解

### DFS树的先序遍历

```java
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null){
            return 0;
        }
        int cur = root.val >= low && root.val <= high ? root.val : 0;
        return cur + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }
```



