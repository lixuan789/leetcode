package lixuan.daydayup;

import java.util.ArrayList;
import java.util.List;

/**
 *
 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 说明：

 所有数字都是正整数。
 解集不能包含重复的组合。
 */
public class Code216CombinationSum3 {
    private List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k>n){
            return res;
        }
        dfs(1,k,n,new ArrayList<Integer>());
        return res;
    }

    private void dfs(int start, int k, int n,ArrayList<Integer> temp) {
        if (k>n){
            return;
        }
        if (k==0&&n==0){
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i=start;i<=9-k+1;i++){//i最大为9-k+1，剪枝
            if (n<i){
                break;
            }
            temp.add(i);
            dfs(i+1,k-1,n-i,temp);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        Code216CombinationSum3 test = new Code216CombinationSum3();
        List<List<Integer>> lists = test.combinationSum3(3, 9);
        System.out.println(lists);
    }
}
