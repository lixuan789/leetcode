package lixuan.daydayup;

/**
 * 在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
 * <p>
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
 * <p>
 * 请你返回最终形体的表面积。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/surface-area-of-3d-shapes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code892surfaceArea {
    public int surfaceArea(int[][] grid) {
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0) {
                    sum += 6 * grid[i][j] - 2 * (grid[i][j] - 1);
                }
                if (i == 0 && j > 0) {
                    sum -= 2 * Math.min(grid[i][j], grid[i][j - 1]);
                }
                if (i > 0 && j == 0) {
                    sum -= 2 * Math.min(grid[i][j], grid[i - 1][j]);
                }
                if (i > 0 && j > 0) {
                    sum -= 2 * Math.min(grid[i - 1][j], grid[i][j]);
                    sum -= 2 * Math.min(grid[i][j - 1], grid[i][j]);
                }
            }
        }
        return sum;
    }
}
