package lixuan.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 */
public class Code77Combine {
    private List<List<Integer>> combines=new ArrayList<>();
    private int n;
    public List<List<Integer>> combine(int n, int k) {
        this.n=n;
        if (n<1||n<k){
            return combines;
        }
        dfs(1,k,new ArrayList<Integer>());
        return combines;
    }

    private void dfs(int start, int k, ArrayList<Integer> combine) {
        if (k==0){
            combines.add(new ArrayList<>(combine));
            return;
        }
        for (int i=start;i<=n-k+1;i++){//剪枝，还剩k个数时，i最大的开始位置可以求出来
            combine.add(i);
            dfs(i+1,k-1,combine);
            combine.remove(combine.size()-1);
        }
    }
}
