package lixuan.interview;

public class OneEditAway {
    /**
     * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，
     * 编写一个函数判定它们是否只需要一次(或者零次)编辑。
     *
     * @param first
     * @param second
     * @return
     */
    public boolean oneEditAway(String first, String second) {
        int m = first == null ? 0 : first.length();
        int n = second == null ? 0 : second.length();
        if (m + n == 0 || first.equals(second)) {
            return true;
        }
        if (m == 0 || Math.abs(m - n) >= 2) {
            return false;
        }
        if (m == n) {
            int cnt = 0;
            for (int i = 0; i < first.length(); i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    cnt++;
                    if (cnt > 1) {
                        return false;
                    }
                }
            }
            return true;
        }
        if (m < n) {
            String temp = first;
            first = second;
            second = temp;
        }
        for (int i = 0; i < first.length(); i++) {
            String str = first.substring(0, i) + first.substring(i + 1);
            if (str.equals(second)) {
                return true;
            }
        }
        return false;
    }

    public boolean oneEditAway1(String first, String second) {
        int len = first.length()-second.length();
        if (len>1||len<-1) {
            return false;
        }
        int count=1;
        for (int i = 0,j=0; i < first.length()&&j < second.length(); i++,j++) {
            if (first.charAt(i)!=second.charAt(j)) {
                if (len==1) { //second要不要添加一个字符
                    j--;
                }else if (len==-1) { //second要不要删除一个字符
                    i--;
                }
                count--;
            }
            if (count<0) {//最多编辑一次
                return false;
            }
        }
        return true;
    }

    /**
     * 编辑距离
     * @param first
     * @param second
     * @return
     */
    public boolean oneEditAway2(String first, String second) {
        int firstLen = first.length();
        int secondLen = second.length();
        int[][] dp = new int[firstLen + 1][secondLen + 1];
        //当第一个字符串为""
        for (int j = 1; j <= secondLen; j++) {
            dp[0][j] = j;
        }
        //当第二个字符串为""
        for (int i = 1; i <= firstLen; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= firstLen; i++) {
            for (int j = 1; j <= secondLen; j++) {
                if (first.charAt(i-1) == second.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //有三种情况，删除，增加，替换(两个长度相等时候就进行替换)
                    //各种操作加一的最小值，就是最小编辑次数
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1] + 1);
                }
            }
        }
        if(dp[firstLen][secondLen]>1){
            return false;
        }
        return true;
    }
}
