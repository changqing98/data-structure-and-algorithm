#### [1049. 最后一块石头的重量 II](https://leetcode-cn.com/problems/last-stone-weight-ii/)

难度中等269

有一堆石头，用整数数组 `stones` 表示。其中 `stones[i]` 表示第 `i` 块石头的重量。

每一回合，从中选出**任意两块石头**，然后将它们一起粉碎。假设石头的重量分别为 `x` 和 `y`，且 `x <= y`。那么粉碎的可能结果如下：

-   如果 `x == y`，那么两块石头都会被完全粉碎；
-   如果 `x != y`，那么重量为 `x` 的石头将会完全粉碎，而重量为 `y` 的石头新重量为 `y-x`。

最后，**最多只会剩下一块** 石头。返回此石头 **最小的可能重量** 。如果没有石头剩下，就返回 `0`。

 

**示例 1：**

```
输入：stones = [2,7,4,1,8,1]
输出：1
解释：
组合 2 和 4，得到 2，所以数组转化为 [2,7,1,8,1]，
组合 7 和 8，得到 1，所以数组转化为 [2,1,1,1]，
组合 2 和 1，得到 1，所以数组转化为 [1,1,1]，
组合 1 和 1，得到 0，所以数组转化为 [1]，这就是最优值。
```

**示例 2：**

```
输入：stones = [31,26,33,21,40]
输出：5
```

**示例 3：**

```
输入：stones = [1,2]
输出：1
```

 

**提示：**

-   `1 <= stones.length <= 30`
-   `1 <= stones[i] <= 100`



## 题解

### 动态规划

题目可以转化为将石头分为两堆，设置石头总重为sum，则两个堆的总重分别为heap与sum - heap，求两个堆的最小差值。

即求绝对值|sum - heap - heap|的最小值，因此我们需要使heap尽可能接近 sum / 2，所以这里就可以转化为背包问题。

设`dp[i][j]`表示前i个物品在重量不超过`j`的时候的重大重量，设maxHeap = sum / 2，

则`dp[stones.length][maxHeap]`表示所有石头在不超出总重一半的最大重量。

```java
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for(int num : stones){
            sum += num;
        }
        int maxHeap = sum / 2;
        int[][] dp = new int[stones.length + 1][maxHeap + 1];
        for(int i = 1; i <= stones.length; i++){
            for(int j = 1; j <= maxHeap; j++){
                if(j < stones[i - 1]){
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i - 1]] + stones[i - 1]);
                }
            }
        }
        return sum - dp[stones.length][maxHeap] * 2;
    }
```

