package lixuan.dp;

/**
 * 给定一个字符串 S 和一个字符串 T，计算在 S 的子序列中 T 出现的个数。
 * <p>
 * 一个字符串的一个子序列是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。
 * （例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 * 示例 1:
 * 输入: S = "rabbbit", T = "rabbit"
 * 输出: 3
 * 解释:
 * 如下图所示, 有 3 种可以从 S 中得到 "rabbit" 的方案。(上箭头符号 ^ 表示选取的字母)
 * rabbbit
 * ^^^^ ^^
 * rabbbit
 * ^^ ^^^^
 * rabbbit
 * ^^^ ^^^
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/distinct-subsequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code115numDistinct {
    /**
     * 令dp[i][j]代表s前i个字母包含t前j个字母的个数
     * 当s[i]==t[j]时则dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
     * 当s[i]！=t[j]时则dp[i][j]=dp[i-1][j]//s删除字符s[i]
     *
     * @param s
     * @param t
     * @return
     */
    public int numDistinct(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 0; i <= s.length(); i++) dp[i][0] = 1;//每个字符串都包含空字符
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                dp[i][j] = (s.charAt(i - 1) == t.charAt(j - 1) ? dp[i - 1][j - 1] : 0) + dp[i - 1][j];
            }
        }
        return dp[n1][n2];
    }
}
