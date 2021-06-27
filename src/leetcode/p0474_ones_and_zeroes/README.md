#### [474. 一和零](https://leetcode-cn.com/problems/ones-and-zeroes/)

难度中等478

给你一个二进制字符串数组 `strs` 和两个整数 `m` 和 `n` 。

请你找出并返回 `strs` 的最大子集的大小，该子集中 **最多** 有 `m` 个 `0` 和 `n` 个 `1` 。

如果 `x` 的所有元素也是 `y` 的元素，集合 `x` 是集合 `y` 的 **子集** 。

 

**示例 1：**

```
输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
输出：4
解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
```

**示例 2：**

```
输入：strs = ["10", "0", "1"], m = 1, n = 1
输出：2
解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
```

 

**提示：**

-   `1 <= strs.length <= 600`
-   `1 <= strs[i].length <= 100`
-   `strs[i]` 仅由 `'0'` 和 `'1'` 组成
-   `1 <= m, n <= 100`



## 题解

### 动态规划

 `dp[i][j][k] `表示对于前i个元素，j <= zeros, k <= ones 最大值



```java
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];
        for(int i = 1; i <= strs.length; i++){
            int[] count = countOnesZeros(strs[i - 1]);
            int ones = count[1];
            int zeros = count[0];
            for(int j = 0; j <= m; j++){
                for(int k = 0; k <= n; k++){
                    if(j >= zeros && k >= ones){
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - zeros][k - ones] + 1);
                    }else {
                        dp[i][j][k] = dp[i - 1][j][k];
                    }
                }
            }
        }
        return dp[strs.length][m][n];
    }

    public int[] countOnesZeros(String str) {
        int ones = 0;
        int zeros = 0;
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(c == '0'){
                zeros++;
            }
            if(c == '1'){
                ones++;
            }
        }
        return new int[]{zeros, ones};
    }
```



