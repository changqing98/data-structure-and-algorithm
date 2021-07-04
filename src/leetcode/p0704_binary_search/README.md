#### [704. 二分查找](https://leetcode-cn.com/problems/binary-search/)

难度简单255

给定一个 `n` 个元素有序的（升序）整型数组 `nums` 和一个目标值 `target` ，写一个函数搜索 `nums` 中的 `target`，如果目标值存在返回下标，否则返回 `-1`。


**示例 1:**

```
输入: nums = [-1,0,3,5,9,12], target = 9
输出: 4
解释: 9 出现在 nums 中并且下标为 4
```

**示例 2:**

```
输入: nums = [-1,0,3,5,9,12], target = 2
输出: -1
解释: 2 不存在 nums 中因此返回 -1
```

 

**提示：**

1.  你可以假设 `nums` 中的所有元素是不重复的。
2.  `n` 将在 `[1, 10000]`之间。
3.  `nums` 的每个元素都将在 `[-9999, 9999]`之间。



## 题解

### 双指针

临界条件考虑：

-   只有一个元素，设置循环终止条件为`l <= r`

```java
    public int search(int[] nums, int target) { 
        int l = 0;
        int r = nums.length - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(nums[mid] == target){
                return mid;
            } else if (nums[mid] > target){
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
```

