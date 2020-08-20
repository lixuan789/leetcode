package lixuan.divideAndConquer;

import java.util.*;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class Code22generateParenthesis {
    private HashMap<Integer, List<String>> map = new HashMap<>();

    public List<String> generateParenthesis(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        List<String> ans = new ArrayList<>();
        if (n == 0) {
            ans.add("");
            return ans;
        }
        for (int i = 0; i < n; i++) {
            List<String> left = generateParenthesis(i);
            List<String> right = generateParenthesis(n - i - 1);
            for (String l : left) {
                for (String r : right) {
                    ans.add(l + "(" + r + ")");
                }
            }
        }
        map.put(n, ans);
        return ans;
    }

    /**
     * DFS+剪枝
     * @param n
     * @return
     */
    private List<String> ans=new ArrayList<>();
    public List<String> generateParenthesis1(int n) {
        List<String> ans=new ArrayList<>();
        if (n==0){
            return ans;
        }
        dfs(0,0,n,"");
        return ans;
    }

    private void dfs(int left, int right, int n, String path) {
        if (left>n||right>n||right>left){
            return;
        }
        if (left==n&&right==n){
            ans.add(path);
        }
        dfs(left+1,right,n,path+"(");
        dfs(left,right+1,n,path+")");
    }

    public static void main(String[] args) {
        Code22generateParenthesis test = new Code22generateParenthesis();
        List<String> list = test.generateParenthesis1(3);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
