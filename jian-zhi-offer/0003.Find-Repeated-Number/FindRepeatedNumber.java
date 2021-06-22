public class FindRepeatedNumber {
  public int findRepeatNumber(int[] nums) {
    int tmp;
    for (int i = 0; i < nums.length; i++) {
      while (nums[i] != i) {
        tmp = nums[i];
        if (nums[tmp] == tmp) {
          return tmp;
        }
        nums[i] = nums[tmp];
        nums[tmp] = tmp;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] case1 = new int[] {1, 2, 3, 4, 5, 6, 5, 8, 9};
    FindRepeatedNumber test = new FindRepeatedNumber();
    System.out.println(test.findRepeatNumber(case1));
  }
}
