package lixuan.hot100;

public class isMatch {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        char[] chars = s.toCharArray();
        char[] charp = p.toCharArray();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            if (charp[i - 1] == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (chars[i - 1] == charp[j - 1] || charp[j - 1] == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (charp[j - 1] == '*') {
                    if (charp[j - 2] == chars[i - 1] || charp[j - 2] == '.') {
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j] || dp[i][j - 1];
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }
        return dp[n][m];
    }
}
