package lixuan.daydayup;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code79Exist {
    private char[][] board;
    private int[] dx={0,0,1,-1};
    private int[] dy={1,-1,0,0};
    public boolean exist(char[][] board, String word) {
        this.board=board;
        if (board==null||board.length==0){
            return false;
        }
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if (dfs(i,j,board,word,0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, char[][] board, String word, int start) {
        if (start==word.length()-1&&word.charAt(start)==board[i][j]){
            return true;
        }
        if (board[i][j]!=word.charAt(start)){
            return false;
        }
        char temp=board[i][j];
        board[i][j]='#';
        for (int k=0;k<4;k++){
            int x=i+dx[k];
            int y=j+dy[k];
            if (x<0||x>=board.length||y<0||y>=board[0].length){
                continue;
            }
            if (dfs(x,y,board,word,start+1)){
                return true;
            }
        }
        board[i][j]=temp;
        return false;
    }

}
