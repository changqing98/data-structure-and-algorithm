package leetcode.p1011_capacity_to_ship_packages_within_d_days;

import java.util.Arrays;

public class ShipWithinDays {
  public int shipWithinDays(int[] weights, int D) {
    int left = Arrays.stream(weights).max().getAsInt();
    int right = Arrays.stream(weights).sum();
    while (left < right) {
      int mid = (left + right) / 2;
      int days = 1;
      int cur = 0;
      for (int weight : weights) {
        if (cur + weight > mid) {
          days++;
          cur = 0;
        }
        cur += weight;
      }
      if (days > D) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return left;
  }
}
