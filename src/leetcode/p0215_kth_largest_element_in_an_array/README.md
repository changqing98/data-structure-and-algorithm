#### [215. 数组中的第K个最大元素](https://leetcode-cn.com/problems/kth-largest-element-in-an-array/)



在未排序的数组中找到第 **k** 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

**示例 1:**

```
输入: [3,2,1,5,6,4] 和 k = 2
输出: 5
```

**示例 2:**

```
输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
输出: 4
```

**说明:**

你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。



## 题解

### 快排思想

```java
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        int targetIndex = nums.length - k;
        dfs(nums, 0, nums.length - 1, targetIndex);
        return nums[targetIndex];
    }

    private void dfs(int[] nums, int start, int end, int targetIndex) {
        int index = partition(nums, start, end);
        if (index == targetIndex) {
            return;
        }
        if (index < targetIndex) {
            dfs(nums, index + 1, end, targetIndex);
        } else {
            dfs(nums, start, index - 1, targetIndex);
        }
    }

    private int partition(int[] nums, int start, int end) {
        int tmp = nums[start];
        while (start < end) {
            while (start < end && nums[end] > tmp) {
                end--;
            }
            nums[start] = nums[end];
            while (start < end && nums[start] <= tmp) {
                start++;
            }
            nums[end] = nums[start];
        }
        nums[start] = tmp;
        return start;
    }
}
```

