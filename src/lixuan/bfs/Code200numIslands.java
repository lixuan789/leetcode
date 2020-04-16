package lixuan.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，
 * 并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * <p>
 * 示例 1:
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * <p>
 * 输出: 1
 */
public class Code200numIslands {
    private int[] dx = {0, 0, 1, -1};
    private int[] dy = {1, -1, 0, 0};

    /**
     * 使用dfs
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            dfs(grid, x, y);
        }
    }

    /**
     * bfs
     * @param grid
     * @return
     */
    public int numIslands1(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    Queue<Integer> queue = new LinkedList<>();
                    queue.offer(i * m + j);
                    grid[i][j] = '0';
                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        while (size-- > 0) {
                            Integer temp = queue.poll();
                            int x = temp / m;
                            int y = temp % m;
                            for (int k = 0; k < 4; k++) {
                                int xx = x + dx[k];
                                int yy = y + dy[k];
                                if (xx >= 0 && xx < n && yy >= 0 && yy < m && grid[xx][yy] == '1') {
                                    queue.offer(xx * m + yy);
                                    grid[xx][yy] = '0';
                                }
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}
