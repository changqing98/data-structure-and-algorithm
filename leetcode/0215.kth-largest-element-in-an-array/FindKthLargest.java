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
