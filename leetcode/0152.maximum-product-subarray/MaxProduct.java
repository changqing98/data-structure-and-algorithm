public class MaxProduct {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int result = nums[0];
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tmpMax = max;
            int tmpMin = min;
            max = Math.max(nums[i], Math.max(tmpMax * nums[i], tmpMin * nums[i]));
            min = Math.min(nums[i], Math.min(tmpMax * nums[i], tmpMin * nums[i]));
            result = Math.max(max, result);
        }
        return result;
    }
}