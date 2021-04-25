#### [剑指 Offer 59 - I. 滑动窗口的最大值](https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/)

难度困难248

给定一个数组 `nums` 和滑动窗口的大小 `k`，请找出所有滑动窗口里的最大值。

**示例:**

```
输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
输出: [3,3,5,5,6,7] 
解释: 

  滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
```

 

**提示：**

你可以假设 *k* 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。



## 题解

### 单调递减队列

```java
 	public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0){
            return nums;
        }
        Deque<Integer> deque = new LinkedList<>();
        int i = 0;
        int[] result = new int[nums.length - k + 1];
        while(i < k){
            while(!deque.isEmpty() && deque.peekLast() < nums[i]){
                deque.pollLast();
            }
            deque.addLast(nums[i]);
            i++;
        }
        result[0] = deque.peekFirst();
        for(; i < nums.length; i++){
            if(deque.peekFirst() == nums[i - k]){
                deque.pollFirst();
            }
            while(!deque.isEmpty() && deque.peekLast() < nums[i]){
                deque.pollLast();
            }
            deque.addLast(nums[i]);
            result[i - k + 1] = deque.peekFirst();
        }
        return result;
    }
```



## 相关题目

- [155.最小栈](../leetcode/../../leetcode/0155.min-stack)