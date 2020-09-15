package lixuan.dp;

/**
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。
 * 假设每一种面额的硬币有无限个。
 */
public class Code518Change {
    /**
     * 完全背包问题
     * 首先，想想为什么01背包问题中要按照v=V...0的逆序来循环。
     * 这是因为要保证第i次循环中的状态f[i][v]是由状态f[i-1][v-c[i]]递推而来。
     * 换句话说，这正是为了保证每件物品只选一次，保证在考虑“选入第i件物品”这件策略时，
     * 依据的是一个绝无已经选入第i件物品的子结果f[i-1][v-c[i]]。
     * 而现在完全背包的特点恰好是每种物品可选无限件，所以在考虑“加选一件dii种物品”这种策略时，
     * 却正需要一个可能已选入第i种物品的子结果f[i][c-v[i]],所以就可以并且必须采用v=0...V的顺序循环
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        if (coins==null||coins.length==0){
            return 0;
        }
        int[] dp=new int[amount+1];
        dp[0]=1;
        for (int coin:coins){
            for (int i=coin;i<=amount;i++){
                dp[i]+=dp[i-coin];
            }
        }
        return dp[amount];
    }
}
