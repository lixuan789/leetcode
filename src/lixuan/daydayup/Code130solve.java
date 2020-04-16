package lixuan.daydayup;

/**
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * 解释:
 *
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。
 * 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。
 * 如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 */
public class Code130solve {
    private int[] dx = {0, 0, 1, -1};
    private int[] dy = {1, -1, 0, 0};

    /**
     * 先填充最外侧，剩下的就是里侧了。
     * @param board
     */
    public void solve(char[][] board) {
        if(board==null||board.length==0){
            return;
        }
        int n=board.length;
        int m=board[0].length;
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                boolean isEdge=i==0||i==n-1||j==0||j==m-1;
                if(isEdge&&board[i][j]=='O'){
                    dfs(board,i,j);
                }
            }
        }
        for (int i=0;i<n;i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j]=='#'){
                    board[i][j]='O';
                }else if(board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }

    }

    private void dfs(char[][] board, int i, int j) {
        if(i<0||i>=board.length||j<0||j>=board[0].length||board[i][j]!='O'){
            return;
        }
        board[i][j]='#';
        for (int k=0;k<4;k++){
            int x=i+dx[k];
            int y=j+dy[k];
            dfs(board,x,y);
        }
    }

}
