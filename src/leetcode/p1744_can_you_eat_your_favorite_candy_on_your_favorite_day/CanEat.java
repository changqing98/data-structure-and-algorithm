package leetcode.p1744_can_you_eat_your_favorite_candy_on_your_favorite_day;

public class CanEat {
  public boolean[] canEat(int[] candiesCount, int[][] queries) {
    long[] sum = new long[candiesCount.length + 1];
    for (int i = 1; i <= candiesCount.length; i++) {
      sum[i] = sum[i - 1] + candiesCount[i - 1];
    }
    boolean[] result = new boolean[queries.length];
    for (int i = 0; i < queries.length; i++) {
      int t = queries[i][0];
      int d = queries[i][1] + 1;
      int c = queries[i][2];
      long fast = sum[t] / c + 1;
      long slow = sum[t + 1];
      result[i] = fast <= d && d <= slow;
    }
    return result;
  }
}
