#### [剑指 Offer 03. 数组中重复的数字](https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/)

难度简单372

找出数组中重复的数字。


在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。

**示例 1：**

```
输入：
[2, 3, 1, 0, 2, 5, 3]
输出：2 或 3 
```

 

**限制：**

```
2 <= n <= 100000
```



## 题解

分析：

对于一个长度为n，且所有的数字都在0 ~ n-1范围内，如果不存在重复的数字，将数组排完序后，则有

$$ nums[i] = i,  0 <= i <= n - 1 $$

例如：nums = [0, 2 ,3 , 4, 1] ，排完序后应该为 [0, 1, 2, 3, 4]

步骤：

1.  依次遍历数组
2.  如果 i 位置上的数值 nums[i] != i ,我们就通过数组交换，把nums[i]放到正确的位置上，设nums[i] 数值为tmp，则其正确的位置应该是nums[tmp]
3.  在交换前需要比较一下 如果 nums[tmp] == tmp ,则tmp即为一个重复数字，否则进行两个数的交换。

```java
class Solution {
    public int findRepeatNumber(int[] nums) {
        int tmp;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) { 
                tmp = nums[i]; 
                if (nums[tmp] == tmp) {
                    return tmp;
                }
                nums[i] = nums[tmp];
                nums[tmp] = tmp;
            }
        }
        return -1;
    }
}
```

