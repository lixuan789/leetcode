package lixuan.daydayup;

public class Code37SolveSudoku {
    private boolean[][] rows;//数字 1-9 在每一行只能出现一次。
    private boolean[][] cols;//数字 1-9 在每一列只能出现一次。
    private boolean[][] block;//数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。

    public void solveSudoku(char[][] board) {
        rows = new boolean[9][10];
        cols = new boolean[9][10];
        block = new boolean[9][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j]!='.') {
                    int num = board[i][j] - '0';
                    rows[i][num] = true;
                    cols[j][num] = true;
                    int cube = (i / 3) * 3 + j / 3;
                    block[cube][num] = true;
                }
            }
        }
        dfs(0, board);
    }

    private boolean dfs(int index, char[][] board) {
        if (index >= 81) {
            return true;
        }
        int row = index / 9;
        int col = index % 9;
        int cube = (row / 3) * 3 + col / 3;
        if (board[row][col] != '.') {
            index++;
            return dfs(index, board);
        }else {
            for (int i = 1; i <= 9; i++) {
                if (rows[row][i] || cols[col][i] || block[cube][i]) {
                    continue;
                }
                board[row][col] = (char)(i+'0');
                rows[row][i] = true;
                cols[col][i] = true;
                block[cube][i] = true;
                if (dfs(index++, board)) {
                    return true;
                }
                board[row][col] = '.';
                rows[row][i] = false;
                cols[col][i] = false;
                block[cube][i] = false;
            }
        }
        return false;
    }
}
