# [01背包](https://www.nowcoder.com/practice/2820ea076d144b30806e72de5e5d4bbf)

## 题目描述

已知一个背包最多能容纳物体的体积为V

现有n个物品第i个物品的体积为v_i*v**i* 第i个物品的重量为w_i*w**i*

求当前背包最多能装多大重量的物品

示例1

## 输入

```
10,2,[[1,3],[10,4]]
```

## 返回值

```
4
```

## 说明

```
第一个物品的体积为1，重量为3，第二个物品的体积为10，重量为4。只取第二个物品可以达到最优方案，取物重量为4 
```

## 备注:

```
1<=2001≤V≤200
1<=2001≤n≤200
1<=2001≤vi≤200
1<=2001≤wi≤200
```



## 题解

### 动态规格

dp[i]\[j] 表示放第i个物品时，背包体积为j时的最大可放入重量。
$$
dp[i][j] = 
\begin{cases}
dp[i - 1][j] & \text{j < vw[i - 1][0]} & 第i个物品体积大于背包体积时只能不放 \\ 
max(dp[i - 1][j], dp[i - 1][j - vw[i - 1][0]] + vw[i - 1][1]) & \text{j >= vw[i - 1][0]} & 比较放与不放的重量，取最大值 
\end{cases}
$$

```java
    public int knapsack(int V, int n, int[][] vw) {
        int dp[][] = new int[n + 1][V + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= V; j++) {
                if (j < vw[i - 1][0]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - vw[i - 1][0]] + vw[i - 1][1]);
                }
            }
        }
        return dp[n][V];
    }
```

