package leetcode.p0034_find_first_and_last_position_of_element_in_sorted_array;

public class BinarySearchRange {
  public int[] searchRange(int[] nums, int target) {
    if (nums.length == 0) {
      return new int[] {-1, -1};
    }
    return new int[] {searchLeftMost(target, nums), searchRightMost(target, nums)};
  }

  public int searchLeftMost(int target, int[] arr) {
    int l = 0;
    int r = arr.length - 1;
    int result = -1;
    while (l <= r) {
      int mid = l + (r - l) / 2;
      if (arr[mid] >= target) {
        r = mid - 1;
      } else {
        l = mid + 1;
      }
      if (arr[mid] == target) {
        result = mid;
      }
    }
    return result;
  }

  public int searchRightMost(int target, int[] arr) {
    int l = 0;
    int r = arr.length - 1;
    int result = -1;
    while (l <= r) {
      int mid = l + (r - l) / 2;
      if (arr[mid] <= target) {
        l = mid + 1;
      } else {
        r = mid - 1;
      }
      if (arr[mid] == target) {
        result = mid;
      }
    }
    return result;
  }
}
