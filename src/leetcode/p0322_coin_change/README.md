#### [322. 零钱兑换](https://leetcode-cn.com/problems/coin-change/)

难度中等1195

给定不同面额的硬币 `coins` 和一个总金额 `amount`。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 `-1`。

你可以认为每种硬币的数量是无限的。

 

**示例 1：**

```
输入：coins = [1, 2, 5], amount = 11
输出：3 
解释：11 = 5 + 5 + 1
```

**示例 2：**

```
输入：coins = [2], amount = 3
输出：-1
```

**示例 3：**

```
输入：coins = [1], amount = 0
输出：0
```

**示例 4：**

```
输入：coins = [1], amount = 1
输出：1
```

**示例 5：**

```
输入：coins = [1], amount = 2
输出：2
```

 

**提示：**

-   `1 <= coins.length <= 12`
-   `1 <= coins[i] <= 231 - 1`
-   `0 <= amount <= 104`



## 题解

### 动态规划

如题 用1、2、5组成11：

$f(11) = min(f(11 - 1)， f(11 - 2), f(11 - 5)) + 1; \\
f(10) = min(f(10 - 1), f(10 - 2), f(10 - 5)) + 1; \\
...
分析初始边界问题
f(5) = min(f(5 - 1), f(5 - 2), f(5 - 5)) + 1; \\
...
f(0) = 0$



1.  coin的最小分值为1，因此对于amount，最多为amount枚硬币组成，我们创建一个amount + 1长度的数组，初始值为amount + 1,表示该数不能由所给的硬币构成
2.  dp[0] = 0;
3.  对于dp[i] , 当 i >= 硬币分值coins[j] 的时候，有 $dp[i] = min(dp[i], dp[i - coins[j]] + 1)$
4.  最终dp[amount]即为最终结果，如果dp[amount] > amount表示不能构成，否则即为构成所需的最少硬币个数

```java
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for(int i = 1; i <= amount; i++) {
            for(int j = 0; j < coins.length; j++){
                if(i >= coins[j]){
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
```

