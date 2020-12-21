package lixuan.daydayup;

public class Code52TotalNQueens {
    /**
     * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
     * @param n
     * @return
     */
    public int totalNQueens(int n) {
        boolean[] visCol=new boolean[n];
        boolean[] dia1=new boolean[2*n-1];//正对角线，x+y相等
        boolean[] dia2=new boolean[2*n-1];//负对角线，n-1+y-x
        return dfs(0,visCol,dia1,dia2,n);
    }

    private int  dfs(int row, boolean[] visCol, boolean[] dia1, boolean[] dia2, int n) {
        int ans=0;
        if (row>=n){
            ans++;
            return ans;
        }
        for (int col=0;col<n;col++){
            if (!visCol[col]&&!dia1[row+col]&&!dia2[n-1+col-row]){
                visCol[col]=true;
                dia1[row+col]=true;
                dia2[n-1+col-row]=true;
                ans+=dfs(row+1, visCol, dia1, dia2,n);
                visCol[col]=false;
                dia1[row+col]=false;
                dia2[n-1+col-row]=false;
            }
        }
        return ans;
    }
}
