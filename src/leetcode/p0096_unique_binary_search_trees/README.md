#### [96. 不同的二叉搜索树](https://leetcode-cn.com/problems/unique-binary-search-trees/)

难度中等1160

给你一个整数 `n` ，求恰由 `n` 个节点组成且节点值从 `1` 到 `n` 互不相同的 **二叉搜索树** 有多少种？返回满足题意的二叉搜索树的种数。

 

**示例 1：**

![img](README.assets/uniquebstn3.jpg)

```
输入：n = 3
输出：5
```

**示例 2：**

```
输入：n = 1
输出：1
```

 

**提示：**

- `1 <= n <= 19`



## 题解

### 动态规划

```java
    public int numTrees(int n) {
        if(n <= 2){
            return n;
        }
        int[] result = new int[n + 1];
        result[0] = 1;
        result[1] = 1;
        result[2] = 2;
        for(int k = 3; k <= n; k++){
            int count = 0;
            for(int i = 1; i <= k; i++){
                int left = i - 1;
                int right = k - i;
                count += result[left] * result[right];
            }
            result[k] = count;
        }
        return result[n];
    }
```



