package lixuan.daydayup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 
 * 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code40CombinationSum2 {
    private List<List<Integer>> res;
    private boolean[] vis;
    private int[] candidates;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.res= new ArrayList<>();
        this.candidates=candidates;
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        int n = candidates.length;
        this.vis = new boolean[n];
        Arrays.sort(candidates);
        dfs(target, new ArrayList<Integer>(),0);
        return res;
    }

    private void dfs(int target, ArrayList<Integer> path, int start) {
        if (target<0||start>candidates.length){
            return;
        }
        if (target==0){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i=start;i<candidates.length;i++){
            if (vis[i]||target<candidates[i]){
                continue;
            }
            if (i>0&&candidates[i]==candidates[i-1]&&!vis[i-1]){
                continue;
            }
            path.add(candidates[i]);
            vis[i]=true;
            dfs(target-candidates[i],path,i+1);
            vis[i]=false;
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums={2,5,2,1,2};
        Code40CombinationSum2 test = new Code40CombinationSum2();
        List<List<Integer>> list = test.combinationSum2(nums, 5);
        System.out.println(list);
    }
}
