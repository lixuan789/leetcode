package lixuan.interview;

import java.util.ArrayList;
import java.util.List;

public class PathWithObstacles {
    /**
     * 迷路的机器人
     *
     * @param obstacleGrid
     * @return
     */
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        List<List<Integer>> ans = new ArrayList<>();
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid == null || obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return ans;
        }
        List<Integer> temp = new ArrayList<>();
        temp.add(0);
        temp.add(0);
        ans.add(temp);
        if (dfs(obstacleGrid, ans, 0, 0)) {
            return ans;
        }
        return new ArrayList<>();
    }

    private boolean dfs(int[][] obstacleGrid, List<List<Integer>> ans, int i, int j) {
        if (i == obstacleGrid.length - 1 && j == obstacleGrid[0].length - 1) {
            return true;
        }
        if (j < obstacleGrid[0].length - 1 && obstacleGrid[i][j + 1] == 0) {
            List<Integer> temp = new ArrayList<>();
            temp.add(i);
            temp.add(j + 1);
            ans.add(temp);
            obstacleGrid[i][j + 1] = 1;
            if (dfs(obstacleGrid, ans, i, j + 1)) {
                return true;
            }
            ans.remove(ans.size() - 1);
        }
        if (i < obstacleGrid.length - 1 && obstacleGrid[i + 1][j] == 0) {
            List<Integer> temp = new ArrayList<>();
            temp.add(i + 1);
            temp.add(j);
            ans.add(temp);
            obstacleGrid[i + 1][j] = 1;
            if (dfs(obstacleGrid, ans, i + 1, j)) {
                return true;
            }
            ans.remove(ans.size() - 1);
        }
        return false;
    }
}
