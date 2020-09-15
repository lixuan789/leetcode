package lixuan.dp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 示例 1:
 * <p>
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code322CoinChange {
    /**
     * 完全背包问题
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {//硬币循环在里面
                if (i - coin < 0) continue;
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    /**
     * 利用bfs求最短距离
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange1(int[] coins, int amount) {
        if (coins == null || coins.length == 0||amount==0) {
            return 0;
        }
        Arrays.sort(coins);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] vis=new boolean[amount+1];
        queue.add(amount);
        vis[amount]=true;
        int res = 0;
        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            while (size-- > 0) {
                Integer num = queue.poll();
                for (int coin : coins) {
                    int next=num-coin;
                    if (next==0){
                        return res;
                    }
                    if (next<0){
                        break;
                    }
                    if (!vis[next]){
                        queue.add(next);
                        vis[next]=true;
                    }
                }
            }
        }
        return -1;
    }


    /**
     * dfs
     * @param coins
     * @param amount
     * @return
     */
    int res = Integer.MAX_VALUE;
    public int coinChange2(int[] coins, int amount){
        if(amount==0){
            return 0;
        }
        Arrays.sort(coins);
        mincoin(coins,amount,coins.length-1,0);
        return res==Integer.MAX_VALUE? -1:res;
    }
    private void mincoin(int[] coins,int amount, int index, int count){
        if(amount==0){
            res = Math.min(res,count);
            return;
        }
        if(index<0){
            return;
        }
        for(int i = amount/coins[index];i>=0 && i+count<res; i--){
            mincoin(coins,amount - (i*coins[index]), index-1, count+i);
        }
    }
}
