package nowcoder.nc0041_max_length;

import java.util.HashMap;
import java.util.Map;

public class MaxLength {
  public int maxLength(int[] arr) {
    Map<Integer, Integer> map = new HashMap<>();
    int max = 0;
    int left = 0;
    for (int i = 0; i < arr.length; i++) {
      if (map.containsKey(arr[i])) {
        left = Math.max(left, map.get(arr[i]) + 1);
      }
      map.put(arr[i], i);
      max = Math.max(max, i - left + 1);
    }
    return max;
  }
}
