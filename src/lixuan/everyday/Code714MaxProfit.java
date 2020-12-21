package lixuan.everyday;

public class Code714MaxProfit {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0] - fee;
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee);
        }
        return dp[n - 1][0];
    }

    public int maxProfit1(int[] prices, int fee) {
        int n = prices.length;
        int dpi_0 = 0;
        int dpi_1 = -prices[0] - fee;
        for (int i = 1; i < n; i++) {
            int temp = dpi_0;
            dpi_0 = Math.max(dpi_0, dpi_1 + prices[i]);
            dpi_1 = Math.max(dpi_1, temp - prices[i] - fee);
        }
        return dpi_0;
    }
}
