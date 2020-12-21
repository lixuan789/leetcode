package lixuan.everyday;

/**
 * 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
 * <p>
 * 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，
 * 但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 * <p>
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。
 * 格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/island-perimeter
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code463IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            boolean first = true;
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    if (grid[i][j] == 1) {
                        if (first) {
                            ans += 4;
                            first = false;
                        } else {
                            if (j > 0 && grid[i][j - 1] == 1) {
                                ans += 2;
                            } else {
                                ans += 4;
                            }
                        }
                    }
                } else {
                    if (grid[i][j] == 1) {
                        if (first) {
                            if (grid[i - 1][j] == 1) {
                                ans += 2;
                            } else {
                                ans += 4;
                            }
                            first = false;
                        } else {
                            if (j > 0 && grid[i][j - 1] == 1) {
                                if (grid[i - 1][j] == 1) {
                                    ans += 0;
                                } else {
                                    ans += 2;
                                }
                            } else {
                                if (grid[i - 1][j] == 1) {
                                    ans += 2;
                                } else {
                                    ans += 4;
                                }
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }

    public int islandPerimeter1(int[][] grid) {
        //重点关注前面遍历过得方格，如果之前有相邻方格，就-2;
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int rsp = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    rsp += 4;
                    if (i > 0 && grid[i - 1][j] == 1) {
                        rsp -= 2;
                    }
                    if (j > 0 && grid[i][j - 1] == 1) {
                        rsp -= 2;
                    }
                }
            }
        }
        return rsp;
    }

    public static void main(String[] args) {
        Code463IslandPerimeter test = new Code463IslandPerimeter();
        int[][] grid = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        System.out.println(test.islandPerimeter(grid));
    }

}
