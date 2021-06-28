#### [剑指 Offer 07. 重建二叉树](https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/)

难度中等402

输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。

 

例如，给出

```
前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
```

返回如下的二叉树：

```
    3
   / \
  9  20
    /  \
   15   7
```

 

**限制：**

```
0 <= 节点个数 <= 5000
```



## 题解

### 递归

```java
public class RebuildTree {
	public TreeNode reBuildTree(int[] preorder, int[] inorder) {
		return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
	}

	public TreeNode helper(int[] preorder, int startPre, int endPre, int[] inorder, int startIn, int endIn) {
		if (startPre > endPre || startIn > endIn) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[startPre]);
		for (int i = startIn; i <= endIn; i++) {
			if (inorder[i] == preorder[startPre]) {
				int len = i - startIn;
				root.left = helper(preorder, startPre + 1, startPre + len, inorder, startIn, i - 1);
				root.left = helper(preorder, startPre + len + 1, endPre, inorder, i + 1, endIn);
				break;
			}
		}
		return root;
	}
}
```

