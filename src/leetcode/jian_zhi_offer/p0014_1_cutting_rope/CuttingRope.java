package leetcode.jian_zhi_offer.p0014_1_cutting_rope;

public class CuttingRope {

  public int cuttingRopeByDP(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 1;
    for (int i = 3; i <= n; i++) {
      for (int j = 1; j < i; j++) {
        dp[i] = Math.max(dp[i], Math.max((i - j) * dp[j], (i - j) * j));
      }
    }
    return dp[n];
  }

  public int cuttingRopeByGreedy(int n) {
    if (n < 4) {
      return n - 1;
    }
    int count = 1;
    while (n > 4) {
      count *= 3;
      n -= 3;
    }
    return count * n;
  }
}
