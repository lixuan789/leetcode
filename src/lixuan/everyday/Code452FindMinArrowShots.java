package lixuan.everyday;

import java.util.Arrays;
import java.util.Comparator;

public class Code452FindMinArrowShots {
    /**
     * 贪心思想：求最小任务数
     *
     * @param points
     * @return
     */
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                long num1 = o1[1];
                long num2 = o2[1];
                if (num1 > num2) {
                    return 1;
                } else if (num1 == num2) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
        int ans = 1;
        int end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                ans++;
                end = points[i][1];
            }
        }
        return ans;
    }

    /**
     * 动态规划
     *
     * @param points
     * @return
     */
    public int findMinArrowShots1(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        int[] dp = new int[points.length];
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                long num1 = o1[0];
                long num2 = o2[0];
                if (num1 > num2) {
                    return 1;
                } else if (num1 == num2) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
        Arrays.fill(dp, 1);
        for (int i = 1; i < points.length; i++) {
            for (int j = 0; j < i; j++) {
                if (points[i][0] > points[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[points.length - 1];
    }

    public static void main(String[] args) {
        Code452FindMinArrowShots test = new Code452FindMinArrowShots();
        int[][] nums = {{-2147483646, -2147483645}, {2147483646, 2147483647}};
        int i = test.findMinArrowShots(nums);
        System.out.println(i);

    }
}
