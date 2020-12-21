package lixuan.everyday;


/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code63UniquePathsWithObstacles {
    /**
     * 动态规划
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if (obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            if (i == 0) {
                for (int j = 0; j < n; j++) {
                    if (obstacleGrid[0][j] == 1) {
                        break;
                    }
                    dp[j] = 1;
                }
            } else {
                for (int j = 0; j < n; j++) {
                    if (j == 0) {
                        if (obstacleGrid[i - 1][j] == 1) {
                            dp[j] = 0;
                        }
                    } else {
                        if (obstacleGrid[i - 1][j] == 1 && obstacleGrid[i][j - 1] == 1) {
                            dp[j] = 0;
                        }
                        if (obstacleGrid[i - 1][j] == 1 && obstacleGrid[i][j - 1] == 0) {
                            dp[j] = dp[j - 1];
                        }
                        if (obstacleGrid[i][j - 1] == 0 && obstacleGrid[i - 1][j] == 0) {
                            dp[j] += dp[j - 1];
                        }
                    }
                }
            }
        }
        return dp[n - 1];
    }

    /**
     * 优化
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] dp = new int[n];
        dp[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                    continue;
                }
                if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[n - 1];
    }

}
