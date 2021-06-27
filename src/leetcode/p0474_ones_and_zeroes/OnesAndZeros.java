public class OnesAndZeros {
  public int findMaxForm(String[] strs, int m, int n) {
    int[][][] dp = new int[strs.length + 1][m + 1][n + 1];
    for (int i = 1; i <= strs.length; i++) {
      int[] count = countOnesZeros(strs[i - 1]);
      int ones = count[1];
      int zeros = count[0];
      for (int j = 0; j <= m; j++) {
        for (int k = 0; k <= n; k++) {
          if (j >= zeros && k >= ones) {
            dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - zeros][k - ones] + 1);
          } else {
            dp[i][j][k] = dp[i - 1][j][k];
          }
        }
      }
    }
    return dp[strs.length][m][n];
  }

  public int[] countOnesZeros(String str) {
    int ones = 0;
    int zeros = 0;
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      if (c == '0') {
        zeros++;
      }
      if (c == '1') {
        ones++;
      }
    }
    return new int[] {zeros, ones};
  }
}
