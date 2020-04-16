package lixuan.dp;

import java.util.Arrays;
import java.util.Comparator;

public class Code646findLongestChain {
    /**
     * 贪心思想：类似任务调度
     *
     * @param pairs
     * @return
     */
    public int findLongestChain(int[][] pairs) {
        if (pairs == null | pairs.length == 0) {
            return 0;
        }
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int len = 0;
        int[] temp = null;
        for (int i = 0; i < pairs.length; i++) {
            if (i == 0) {
                temp = pairs[i];
                len++;
            } else {
                if (pairs[i][0] > temp[1]) {
                    len++;
                    temp = pairs[i];
                }
            }
        }
        return len;
    }

    /**
     * 动态规划
     *
     * @param pairs
     * @return
     */
    public int findLongestChain1(int[][] pairs) {
        if (pairs == null | pairs.length == 0) {
            return 0;
        }
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int n = pairs.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n - 1];
    }
}
