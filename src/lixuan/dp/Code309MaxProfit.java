package lixuan.dp;

/**
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 * <p>
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * <p>
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code309MaxProfit {
    /**
     * dp[i][k][2]:第i天交易次数为k当前拥有股票的状态时（0为未拥有，1为拥有）的最大利润
     * 通用三维dp：
     * dp[i][k][0]=max(dp[i-1][k][0],dp[i-1][k][1]+prices[i])
     * dp[i][k][1]=max(dp[i-1][k][1],dp[i-1][k-1][0]-prices[i])
     * <p>
     * 此题需要冻结一天
     * dp[i][k][0]=max(dp[i-1][k][0],dp[i-1][k][1]+prices[i])
     * dp[i][k][1]=max(dp[i-1][k][1],dp[i-2][k-1][0]-prices[i])
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int n = prices.length;
        if (n == 2) {
            return prices[1] - prices[0] >= 0 ? prices[1] - prices[0] : 0;
        }
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[1][0] = Math.max(prices[1] - prices[0], 0);
        dp[1][1] = Math.max(-prices[0], -prices[1]);
        for (int i = 2; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        }
        return Math.max(0, dp[n - 1][0]);
    }
}
