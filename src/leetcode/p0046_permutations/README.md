#### [46. 全排列](https://leetcode-cn.com/problems/permutations/)

难度中等 1418

给定一个不含重复数字的数组 `nums` ，返回其 **所有可能的全排列** 。你可以 **按任意顺序** 返回答案。

**示例 1：**

```
输入：nums = [1,2,3]
输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
```

**示例 2：**

```
输入：nums = [0,1]
输出：[[0,1],[1,0]]
```

**示例 3：**

```
输入：nums = [1]
输出：[[1]]
```

**提示：**

- `1 <= nums.length <= 6`
- `-10 <= nums[i] <= 10`
- `nums` 中的所有整数 **互不相同**

## 题解

### DFS + 回溯

1.  

```java
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, 0, result);
        return result;
    }

    public void dfs(int[] nums, int k, List<List<Integer>> result){
        if(k == nums.length - 1){
            result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }
        for(int i = k; i < nums.length; i++){
            swap(nums, i, k);
            dfs(nums, k + 1, result);
            swap(nums, i, k);
        }
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
```
