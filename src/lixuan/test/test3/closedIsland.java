package lixuan.test.test3;

/**
 * 有一个二维矩阵 grid ，每个位置要么是陆地（记号为 0 ）要么是水域（记号为 1 ）。
 * <p>
 * 我们从一块陆地出发，每次可以往上下左右 4 个方向相邻区域走，能走到的所有陆地区域，我们将其称为一座「岛屿」。
 * <p>
 * 如果一座岛屿 完全 由水域包围，即陆地边缘上下左右所有相邻区域都是水域，那么我们将其称为 「封闭岛屿」。
 * <p>
 * 请返回封闭岛屿的数目。
 */
public class closedIsland {
    private int[] dx = {0, 0, 1, -1};
    private int[] dy = {1, -1, 0, 0};
    private int[][] grid;

    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        this.grid = grid;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                boolean isEdeg = i == 0 || i == n - 1 || j == 0 || j == m - 1;
                if (isEdeg && grid[i][j] == 0) {//从外侧将0填充为1，因为外侧的0没有被1包围
                    dfs(i, j, grid);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {//计算岛屿个数，即求连通分量
                    dfs(i, j, grid);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(int i, int j, int[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 1) {
            return;
        }
        if (grid[i][j] == 0) {
            grid[i][j] = 1;
            for (int k = 0; k < 4; k++) {
                int x = i + dx[k];
                int y = j + dy[k];
                dfs(x, y, grid);
            }
        }
    }
}
