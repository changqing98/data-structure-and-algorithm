#### [剑指 Offer 37. 序列化二叉树](https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof/)



请实现两个函数，分别用来序列化和反序列化二叉树。

**示例:** 

```
你可以将以下二叉树：

    1
   / \
  2   3
     / \
    4   5

序列化为 "[1,2,3,null,null,4,5]"
```



## 题解

```java
public class Codec {

    public String serialize(TreeNode root) {
        if(root == null){
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node != null){
                sb.append(node.val).append(",");
                queue.add(node.left);
                queue.add(node.right);
            } else {
                sb.append("null,");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if(data == null || "[]".equals(data)){
            return null;
        }
        data = data.substring(1, data.length() - 1);
        String[] values = data.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(!"null".equals(values[i])){
                TreeNode left = new TreeNode(Integer.valueOf(values[i]));
                node.left = left;
                queue.add(left);
            }
            i++;
            if(!"null".equals(values[i])){
                TreeNode right = new TreeNode(Integer.valueOf(values[i]));
                node.right = right;
                queue.add(right);
            }
            i++;
        }
        return root;
    }
}
```

