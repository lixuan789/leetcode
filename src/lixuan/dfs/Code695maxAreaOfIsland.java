package lixuan.dfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 
 * 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。你可以假设二维矩阵的四个边缘都被水包围着。
 * <p>
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-area-of-island
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code695maxAreaOfIsland {
    private int[] dx = {0, 0, -1, 1};
    private int[] dy = {1, -1, 0, 0};

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, dfs(i, j, grid));
                }
            }
        }
        return res;
    }

    /**
     * dfs:使用系统栈
     *
     * @param i
     * @param j
     * @param grid
     * @return
     */
    private int dfs(int i, int j, int[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        int num = 1;
        grid[i][j] = 0;//沉岛
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            num += dfs(x, y, grid);
        }
        return num;
    }

    /**
     * bfs:使用队列
     *
     * @param grid
     * @return
     */
    public int maxAreaOfIsland1(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int res = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    int temp = 0;
                    queue.add(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        temp++;
                        int[] poll = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int x = poll[0] + dx[k];
                            int y = poll[1] + dy[k];
                            if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1) {
                                grid[x][y] = 0;
                                queue.add(new int[]{x, y});
                            }
                        }
                    }
                    res = Math.max(res, temp);
                }
            }
        }
        return res;
    }
}
