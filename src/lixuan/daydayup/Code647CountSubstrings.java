package lixuan.daydayup;

/**
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 */
public class Code647CountSubstrings {
    public int countSubstrings(String s) {
        int res = 0;
        int n = s.length();
        // dp[i][j] 表示[i,j]的字符是否为回文子串
        boolean[][] dp = new boolean[n][n];
        // 注意，外层循环要倒着写，内层循环要正着写
        // 因为要求dp[i][j] 需要知道dp[i+1][j-1]
        for(int i=n-1; i>=0; i--){
            for(int j=i; j<n; j++){
                // (s.charAt(i)==s.charAt(j) 时，当元素个数为1,2,3个时，一定为回文子串
                if(s.charAt(i)==s.charAt(j) && (j-i<=2 || dp[i+1][j-1])){
                    dp[i][j] = true;
                    res++;
                }
            }
        }

        return res;
    }


    private int num = 0;

    /**
     * manacher算法
     * @param s
     * @return
     */
    public int countSubstrings1(String s) {
        for (int i=0; i < s.length(); i++){
            count(s, i, i);//回文串长度为奇数
            count(s, i, i+1);//回文串长度为偶数
        }
        return num;
    }

    public void count(String s, int start, int end){
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            num++;
            start--;
            end++;
        }
    }

    public static void main(String[] args) {
        Code647CountSubstrings test = new Code647CountSubstrings();
        int num = test.countSubstrings("aaa");
        System.out.println(num);
    }
}
