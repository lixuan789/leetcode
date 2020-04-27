package lixuan.dp;

/**
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * <p>
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code123maxProfit {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) return 0;
        int k = 2;
        int[][][] dp = new int[len][k+1][2];

        for(int i = 0; i < len; i ++){
            for(int j = k; j > 0; j --){
                if (i == 0){
                    //第i天，还有j次，手里没有股票，当i=0，手里没股票，最大利润为0
                    dp[i][j][0] = 0;
                    //当i=0，手里有股票，因为还没有盈利，最大利润为 负prices[i]
                    dp[i][j][1] = -prices[i];
                    continue;
                }
                //今天手里没股票，比较MAX（前一天可能没股票，前一天有股票但是今天卖出去了，卖出去就有利润，所以+ prices[i]）
                dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1] + prices[i]);
                //今天手里有股票，比较MAX（前一天可能有股票，前一天没股票但是今天买了，买了就有成本，所以- prices[i]）
                dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][0] - prices[i]);
            }
        }
        return dp[len-1][k][0];
    }
}
