public class RegularExpressionMatching {

    /**
     * dp[i][j] = p[j] != '*'
     * 
     * if match(s[i], p[j]) dp[i - 1][j -1] else false
     * 
     * p[j] == '*'
     * 
     * if match(s[i], p[j - 1]) dp[i-1][j] || dp[i][j-2] else dp[i][j - 2]
     */
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) != '*') {
                    dp[i][j] = match(s, p, i, j) ? dp[i - 1][j - 1] : false;
                } else {
                    if (match(s, p, i, j - 1)) {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }
        return dp[m][n];
    }

    /**
     * i j 表示在字符串中的实际索引位置 从1开始，而不是0
     */
    private boolean match(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
