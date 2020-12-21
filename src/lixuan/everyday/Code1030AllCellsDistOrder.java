package lixuan.everyday;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Code1030AllCellsDistOrder {
    /**
     * 桶排序
     *
     * @param R
     * @param C
     * @param r0
     * @param c0
     * @return
     */
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        List<int[]>[] bukect = new List[201];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int dis = Math.abs(i - r0) + Math.abs(j - c0);
                if (bukect[dis] == null) {
                    bukect[dis] = new ArrayList<>();
                }
                bukect[dis].add(new int[]{i, j});
            }
        }
        List<int[]> ans = new ArrayList<>();
        for (int i = 0; i < bukect.length; i++) {
            if (bukect[i] == null) {
                continue;
            }
            ans.addAll(bukect[i]);
        }
        int[][] array = ans.toArray(new int[ans.size()][]);
        return array;
    }

    /**
     * bfs
     *
     * @param R
     * @param C
     * @param r0
     * @param c0
     * @return
     */
    public int[][] allCellsDistOrder2(int R, int C, int r0, int c0) {
        boolean[][] vis = new boolean[R][C];
        List<int[]> ans = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int[] frist = {r0, c0};
        queue.add(frist);
        vis[r0][c0] = true;
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                int[] poll = queue.remove();
                ans.add(poll);
                for (int j = 0; j < 4; j++) {
                    int x = poll[0] + dx[j];
                    int y = poll[1] + dy[j];
                    if (x < 0 || x >= R || y < 0 || y >= C || vis[x][y]) {
                        continue;
                    }
                    queue.add(new int[]{x, y});
                }
            }
        }
        int[][] array = ans.toArray(new int[ans.size()][]);
        return array;
    }

    /**
     * 类BFS
     * @param R
     * @param C
     * @param r0
     * @param c0
     * @return
     */
    public int[][] allCellsDistOrder1(int R, int C, int r0, int c0) {
        int[][] re = new int[R * C][2];
        re[0][0] = r0;
        re[0][1] = c0;
        int[] dr = {1, 1, -1, -1};
        int[] dc = {1, -1, -1, 1};
        int row = r0;
        int col = c0;
        var cnt = 1;
        while (cnt < R * C) {
            row--;
            for (int i = 0; i < 4; i++) {
                while ((i % 2 == 0 && row != r0) || (i % 2 != 0 && col != c0)) {
                    if (row >= 0 && row < R && col >= 0 && col < C) {
                        re[cnt][0] = row;
                        re[cnt][1] = col;
                        cnt++;
                    }
                    row += dr[i];
                    col += dc[i];
                }
            }
        }
        return re;
    }
}
