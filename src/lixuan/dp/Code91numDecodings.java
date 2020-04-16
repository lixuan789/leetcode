package lixuan.dp;

/**
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 */
public class Code91numDecodings {
    /**
     * 上楼梯的复杂版？
     *     如果连续的两位数符合条件，就相当于一个上楼梯的题目，可以有两种选法：
     *         1.一位数决定一个字母
     *         2.两位数决定一个字母
     *         就相当于dp(i) = dp[i-1] + dp[i-2];
     *     如果不符合条件，又有两种情况
     *         1.当前数字是0：
     *             不好意思，这阶楼梯不能单独走，
     *             dp[i] = dp[i-2]
     *         2.当前数字不是0
     *             不好意思，这阶楼梯太宽，走两步容易扯着步子，只能一个一个走
     *             dp[i] = dp[i-1];
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.equals('0')) {
            return 0;
        }
        if(s.length()==1){
            return 1;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        char[] array = s.toCharArray();
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            dp[i+1]=array[i]=='0'?0:dp[i];
            if (i > 0 && (array[i - 1] == '1' || (array[i - 1] == '2' && array[i] <= '6'))) {
                dp[i+1]+=dp[i-1];
            }
        }
        return dp[n];
    }
}

