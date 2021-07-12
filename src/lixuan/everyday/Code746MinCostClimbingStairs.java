package lixuan.everyday;

public class Code746MinCostClimbingStairs {
    /**
     * 使用dp记录状态
     *
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];//到索引i的最低花费
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return Math.min(dp[n - 2], dp[n - 1]);
    }


    /**
     * 用变量进行优化
     *
     * @param cost
     * @return
     */
    public int minCostClimbingStairs1(int[] cost) {
        int n = cost.length;
        int prei_2 = cost[0];
        int prei_1 = cost[1];
        for (int i = 2; i < n; i++) {
            int pre = Math.min(prei_1, prei_2) + cost[i];
            prei_2 = prei_1;
            prei_1 = pre;
        }
        return Math.min(prei_2, prei_1);
    }
}
