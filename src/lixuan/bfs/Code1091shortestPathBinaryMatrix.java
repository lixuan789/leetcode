package lixuan.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 在一个 N × N 的方形网格中，每个单元格有两种状态：空（0）或者阻塞（1）。
 * <p>
 * 一条从左上角到右下角、长度为 k 的畅通路径，由满足下述条件的单元格 C_1, C_2, ..., C_k 组成：
 * <p>
 * 相邻单元格 C_i 和 C_{i+1} 在八个方向之一上连通（此时，C_i 和 C_{i+1} 不同且共享边或角）
 * C_1 位于 (0, 0)（即，值为 grid[0][0]）
 * C_k 位于 (N-1, N-1)（即，值为 grid[N-1][N-1]）
 * 如果 C_i 位于 (r, c)，则 grid[r][c] 为空（即，grid[r][c] == 0）
 * 返回这条从左上角到右下角的最短畅通路径的长度。如果不存在这样的路径，返回 -1 。
 */
public class Code1091shortestPathBinaryMatrix {
    private int[] dx = {0, 0, 1, -1, 1, -1, -1, 1};
    private int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};

    /**
     * 方法：使用bfs
     * @param grid
     * @return
     */
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }

        int n = grid.length;
        int m = grid[0].length;
        if (grid[0][0] != 0 || grid[n - 1][m - 1] != 0) {
            return -1;
        }
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        int res = 0;
        queue.add(new int[]{0, 0});
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            res++;
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int[] temp = queue.poll();
                int x = temp[0];
                int y = temp[1];
                if (x == n - 1 && y == m - 1) {
                    return res;
                }
                for (int k = 0; k < 8; k++) {
                    int xx = x + dx[k];
                    int yy = y + dy[k];
                    if (xx >= 0 && xx < n && yy >= 0 && yy < m && grid[xx][yy] == 0 && visited[xx][yy] == false) {
                        queue.offer(new int[]{xx, yy});
                        visited[xx][yy] = true;
                    }
                }
            }
        }
        return -1;
    }
}
