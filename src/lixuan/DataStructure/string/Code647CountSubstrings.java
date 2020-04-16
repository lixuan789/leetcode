package lixuan.DataStructure.string;

import java.util.Arrays;

/**
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 */
public class Code647CountSubstrings {
    /**
     * 暴力法
     *
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        int n = s.length();
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                String str = s.substring(i, j + 1);
                if (isPalindrome(str)) {
                    res++;
                }
            }
        }
        return res;
    }

    private boolean isPalindrome(String str) {
        for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    private int cnt = 0;

    /**
     * 从字符串的某一位开始，尝试着去扩展子字符串。
     * 中心扩展法
     *
     * @param s
     * @return
     */
    public int countSubstrings1(String s) {
        for (int i = 0; i < s.length(); i++) {
            extendSubstrings(s, i, i);     // 奇数长度
            extendSubstrings(s, i, i + 1); // 偶数长度
        }
        return cnt;
    }

    private void extendSubstrings(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
            cnt++;
        }
    }

    /**
     * 动态规划
     * dp[i][j]表示字符串i-j是回文串，则：
     * dp[i][j]=dp[i+1][j-1]&&(s[i]==s[j]);
     *
     * @param s
     * @return
     */
    public int countSubstrings2(String s) {
        int res = 0;
        int n = s.length();
        // dp[i][j] 表示[i,j]的字符是否为回文子串
        boolean[][] dp = new boolean[n][n];
        // 注意，外层循环要倒着写，内层循环要正着写
        // 因为要求dp[i][j] 需要知道dp[i+1][j-1]
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                // (s.charAt(i)==s.charAt(j) 时，当元素个数为1,2,3个时，一定为回文子串
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    res++;
                }
            }
        }
        return res;
    }
}
