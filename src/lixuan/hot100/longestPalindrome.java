package lixuan.hot100;

//最长回文子串
public class longestPalindrome {
    /**
     * 动态规划
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;
        char[] chars = s.toCharArray();
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int len = -1;
        String res = "";
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = chars[i] == chars[j] && (j - i < 2 || dp[i + 1][j - 1]);
                if (dp[i][j] && j - i + 1 > len) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

    /**
     * 中心扩展
     *
     * @param s
     * @return
     */
    public String longestPalindrome1(String s) {
        if (s == null || s.length() < 2) return s;
        char[] chars = s.toCharArray();
        int n = s.length();
        String res = "";
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            String res1 = find(s, i, i);
            String res2 = find(s, i, i + 1);
            if (res1.length() > res2.length()) {
                if (res1.length() > maxLen) {
                    res = res1;
                    maxLen = res1.length();
                }
            } else {
                if (res2.length() > maxLen) {
                    res = res2;
                    maxLen = res2.length();
                }
            }
        }
        return res;
    }

    private String find(String s, int i, int j) {
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
            } else {
                break;
            }
        }
        return s.substring(i + 1, j);
    }
}
