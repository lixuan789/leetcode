package lixuan.daydayup;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 * 两个相邻元素间的距离为 1 。
 */
public class Code542UpdateMatrix {
    private int[] dx = {0, 0, 1, -1};
    private int[] dy = {1, -1, 0, 0};

    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    int path = bfs(matrix, i, j);
                    matrix[i][j] = path;
                }
            }
        }
        return matrix;
    }

    private int bfs(int[][] matrix, int i, int j) {
        int ans = 0;
        Queue<Integer> queue = new LinkedList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        visited[i][j] = true;
        queue.add(i * m + j);
        while (!queue.isEmpty()) {
            ans++;
            int len = queue.size();
            while (len-- > 0) {
                Integer poll = queue.poll();
                int x = poll / m;
                int y = poll % m;
                for (int k = 0; k < 4; k++) {
                    int xx = x + dx[k];
                    int yy = y + dy[k];
                    if (xx < 0 || xx >= m || yy < 0 || yy >= n || visited[xx][yy]) {
                        continue;
                    }
                    if (matrix[xx][yy] == 0) {
                        return ans;
                    }
                    visited[xx][yy] = true;
                    queue.add(xx * m + yy);
                }
            }
        }
        return ans;
    }

    int[][] directions = new int[][]{{0,-1},{0,1},{1,0},{-1,0}};

    /**
     * AC代码
     * @param matrix
     * @return
     */
    public int[][] updateMatrix1(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return matrix;
        int n = matrix.length, m = matrix[0].length;
        int[][] res = new int[n][m];
        // 标记当前位置是否都看过
        boolean[][] visited = new boolean[n][m];
        // BFS 队列
        Queue<int []> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 将 0 全部放入队列
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        while (!queue.isEmpty()){
            int[] top = queue.poll();
            int x = top[0], y = top[1];
            // BFS 搜索四个方向
            for (int[] direction : directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                if (newX < 0 || newX >= n || newY < 0 || newY >= m || visited[newX][newY]) continue;
                res[newX][newY] = res[x][y] + 1;  // 距离更新
                visited[newX][newY] = true;
                queue.add(new int[]{newX, newY});   // 新元素入队
            }
        }
        return res;
    }
}
