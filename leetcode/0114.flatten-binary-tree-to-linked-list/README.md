# [114. 二叉树展开为链表](https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list)

## 题解

### 反向后序便利


```java
TreeNodeTraversal prev;
public void flatten(TreeNodeTraversal root) {
    if(root == null){
        return;
    }
    flatten(root.right);
    flatten(root.left);
    root.left = null;
    root.right = prev;
    prev = root;
}
```