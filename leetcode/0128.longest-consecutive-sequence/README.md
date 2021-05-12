#### [128. 最长连续序列](https://leetcode-cn.com/problems/longest-consecutive-sequence/)

难度困难762

给定一个未排序的整数数组 `nums` ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。

 

**进阶：**你可以设计并实现时间复杂度为 `O(n)` 的解决方案吗？

 

**示例 1：**

```
输入：nums = [100,4,200,1,3,2]
输出：4
解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
```

**示例 2：**

```
输入：nums = [0,3,7,2,5,8,4,6,0,1]
输出：9
```

 

**提示：**

- `0 <= nums.length <= 104`
- `-109 <= nums[i] <= 109`



## 题解

### Hash表

1. 将数组元素添加到Hash表；

2. 我们按照递增的方向统计连续长度，统计每一个数往后的最大连续长度，

   如何优化？

   假设有连续元素 x、x+1、x+2、x+3 ...  x + n，则x + 1、x + 2、x + 3 ... x + n都不需要统计，可以直接跳过。

   如何判断能不能跳过该数呢？

   其实我们可以通过判断 x - 1是否存在，判断x是否可以跳过统计。因为如果 x - 1存在的话，统计x - 1的时候，一定会覆盖到x。

3. 返回最大长度。

```java
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int result = 0;
        for (int num : nums) {
          	// 判断是否跳过统计
            if (!set.contains(num - 1)) {
                int cur = num;
                int len = 1;
                while (set.contains(cur + 1)) {
                    cur++;
                    len++;
                }
                result = Math.max(result, len);
            }
        }
        return result;
    }
```

