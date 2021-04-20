#### [103. 二叉树的锯齿形层序遍历](https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/)

难度中等436

给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

例如：
给定二叉树 `[3,9,20,null,null,15,7]`,

```
    3
   / \
  9  20
    /  \
   15   7
```

返回锯齿形层序遍历如下：

```
[
  [3],
  [20,9],
  [15,7]
]
```



## 题解

### BFS

```java
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> result = new ArrayList<>();
        int row = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            Deque<Integer> item = new LinkedList<>();
            while(size != 0){
                TreeNode node = queue.poll();
                if(row % 2 == 0){
                    item.offerLast(node.val);
                } else {
                    item.offerFirst(node.val);
                }
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }    
            row++;
            result.add(new ArrayList(item));
        }
        return result;
    }
```

