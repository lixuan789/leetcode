package lixuan.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。
 * “太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。
 * 规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。
 * 请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pacific-atlantic-water-flow
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code417PacificAtlantic {
    /**
     * 类似于题目130
     *
     * @param matrix
     * @return
     */
    private int m;
    private int n;
    private int[][] matrix;
    private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return ans;
        }
        m = matrix.length;
        n = matrix[0].length;
        this.matrix = matrix;
        boolean[][] visitP = new boolean[m][n];//太平洋,位于左上角
        boolean[][] visitA = new boolean[m][n];//大西洋，右下角
        for (int i = 0; i < m; i++) {
            dfs(i, 0, visitP);
            dfs(i, n - 1, visitA);
        }
        for (int i = 0; i < n; i++) {
            dfs(0, i, visitP);
            dfs(m - 1, i, visitA);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visitA[i][j] && visitP[i][j]) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    ans.add(temp);
                }
            }
        }
        return ans;
    }

    private void dfs(int i, int j, boolean[][] visit) {
        visit[i][j] = true;
        for (int[] d : direction) {
            int x = i + d[0];
            int y = i + d[1];
            if (x < 0 || x >= m || y < 0 || y >= n || visit[x][y] || matrix[x][y] < matrix[i][j]) {
                continue;
            }
            dfs(x, y, visit);
        }
    }
}
