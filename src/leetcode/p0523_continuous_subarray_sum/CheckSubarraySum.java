import java.util.HashSet;
import java.util.Set;

public class CheckSubarraySum {

  public boolean checkSubarraySum(int[] nums, int k) {
    int[] sum = new int[nums.length + 1];
    for (int i = 1; i <= nums.length; i++) {
      sum[i] = sum[i - 1] + nums[i - 1];
    }
    Set<Integer> set = new HashSet<>();
    for (int i = 2; i <= nums.length; i++) {
      set.add(sum[i - 2] % k);
      if (set.contains(sum[i - 1] % k)) {
        return true;
      }
    }
    return false;
  }
}
