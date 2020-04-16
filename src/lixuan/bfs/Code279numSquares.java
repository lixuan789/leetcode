package lixuan.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。
 * 你需要让组成和的完全平方数的个数最少。
 * 示例 1:
 * <p>
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 */
public class Code279numSquares {
    /**
     * 转化为bfs求最短距离
     * @param n
     * @return
     */
    public int numSquares(int n) {
        List<Integer> squares = generateSquares(n);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        queue.offer(n);
        visited[n] = true;
        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Integer temp = queue.poll();
                for (Integer num : squares) {
                    int cur = temp - num;
                    if (cur > 0 && visited[cur] == false) {
                        queue.add(cur);
                        visited[cur] = true;
                    }
                    if (cur == 0) {
                        return level+1;
                    }
                    if (cur < 0) {
                        break;
                    }
                }
            }
        }
        return n;
    }

    private List<Integer> generateSquares(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n / 2 + 1; i++) {
            int num = i * i;
            if (num <= n) {
                list.add(num);
            }
        }
        return list;
    }

    /**
     * 动态规划：dp[i]=Math.min(dp[i],dp[i-j*j]+1);
     * @param n
     * @return
     */
    public int numSquares1(int n) {
        int[] dp=new int[n+1];
        for (int i=1;i<=n;i++){
            dp[i]=i;//最大1+1+。。。
            for (int j=1;i-j*j>=0;j++){
                dp[i]=Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];
    }
}
