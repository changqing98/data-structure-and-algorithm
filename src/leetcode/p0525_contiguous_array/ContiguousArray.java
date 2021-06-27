package leetcode.p0525_contiguous_array;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
  public int findMaxLength(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    int counter = 0;
    map.put(counter, -1);
    int result = 0;
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      if (num == 1) {
        counter++;
      } else {
        counter--;
      }
      if (map.containsKey(counter)) {
        result = Math.max(result, i - map.get(counter));
      } else {
        map.put(counter, i);
      }
    }
    return result;
  }
}
