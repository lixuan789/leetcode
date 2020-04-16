package lixuan.daydayup;

public class Code999numRookCaptures {
    public int numRookCaptures(char[][] board) {
        if (board == null || board.length == 0) {
            return 0;
        }
        int n = board.length;
        int m = board[0].length;
        int x = 0;
        int y = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'R') {
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        int res = 0;
        for (int col = y - 1; col >= 0; col--) {
            if (board[x][col] == 'B') {
                break;
            }
            if (board[x][col] == 'p') {
                res++;
                break;
            }
        }
        for (int col = y + 1; col < m; col++) {
            if (board[x][col] == 'B') {
                break;
            }
            if (board[x][col] == 'p') {
                res++;
                break;
            }
        }
        for (int row = x - 1; row >= 0; row--) {
            if (board[row][y] == 'B') {
                break;
            }
            if (board[row][y] == 'p') {
                res++;
                break;
            }
        }
        for (int row = x + 1; row < n; row++) {
            if (board[row][y] == 'B') {
                break;
            }
            if (board[row][y] == 'p') {
                res++;
                break;
            }
        }
        return res;
    }

}
