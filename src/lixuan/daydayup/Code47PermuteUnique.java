package lixuan.daydayup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 */
public class Code47PermuteUnique {
    private List<List<Integer>> res;
    private boolean[] vis;
    private int[] nums;
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums==null||nums.length==0){
            return res;
        }
        res=new ArrayList<>();
        int n=nums.length;
        vis=new boolean[n];
        this.nums=nums;
        Arrays.sort(nums);
        dfs(new ArrayList<Integer>(),vis,res);
        return res;
    }

    private void dfs(ArrayList<Integer> temp, boolean[] vis, List<List<Integer>> res) {
        if (temp.size()==nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i=0;i<nums.length;i++){
            if (vis[i]||i>0&&nums[i]==nums[i-1]&&!vis[i-1]){
                continue;
            }
            vis[i]=true;
            temp.add(nums[i]);
            dfs(temp,vis,res);
            temp.remove(temp.size()-1);
            vis[i]=false;
        }
    }

    public static void main(String[] args) {
        Code47PermuteUnique test = new Code47PermuteUnique();
        int[] nums={1,1,2};
        List<List<Integer>> list = test.permuteUnique(nums);
        System.out.println(list);
    }
}
