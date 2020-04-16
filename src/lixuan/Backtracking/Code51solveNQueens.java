package lixuan.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 在 n*n 的矩阵中摆放 n 个皇后，并且每个皇后不能在同一行，同一列，同一对角线上，求所有的 n 皇后的解。
 * <p>
 * 一行一行地摆放，在确定一行中的那个皇后应该摆在哪一列时，需要用三个标记数组来确定某一列是否合法，
 * 这三个标记数组分别为：列标记数组、45 度对角线标记数组和 135 度对角线标记数组。
 * <p>
 * 45 度对角线标记数组的长度为 2 * n - 1，通过下图可以明确 (r, c) 的位置所在的数组下标为 r + c。
 * 135 度对角线标记数组的长度也是 2 * n - 1，(r, c) 的位置所在的数组下标为 n - 1 - (r - c)。
 */
public class Code51solveNQueens {
    private List<List<String>> slutions;
    private boolean[] colUsed;
    private boolean[] degrees45Used;
    private boolean[] degrees135Used;
    private char[][] board;
    private int n;
    public List<List<String>> solveNQueens(int n) {
        slutions = new ArrayList<>();
        colUsed = new boolean[n];
        degrees45Used = new boolean[2 * n - 1];
        degrees135Used = new boolean[2 * n - 1];
        this.n = n;
        board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        dfs(0);
        return slutions;
    }

    private void dfs(int row) {
        if (row == n) {
            ArrayList<String> list = new ArrayList<>();
            for (char[] chars : board) {
                list.add(new String(chars));
            }
            slutions.add(list);
            return;
        }
        for (int col = 0; col < n; col++) {
            int diagonals45Idx = row + col;
            int diagonals135Idx = n - 1 - (row - col);
            if (colUsed[col] || degrees45Used[diagonals45Idx] || degrees135Used[diagonals135Idx]) {
                continue;
            }
            colUsed[col] = degrees45Used[diagonals45Idx] = degrees135Used[diagonals135Idx] = true;
            board[row][col] = 'Q';
            dfs(row + 1);
            board[row][col] = '.';
            colUsed[col] = degrees45Used[diagonals45Idx] = degrees135Used[diagonals135Idx] = false;
        }
    }
}
