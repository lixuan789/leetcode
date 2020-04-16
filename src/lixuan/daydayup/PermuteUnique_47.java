package lixuan.daydayup;

import java.util.*;

public class PermuteUnique_47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        int len=nums.length;
        if(len==0){
            return ans;
        }
        boolean[] used=new boolean[len];
        Arrays.sort(nums);
        Deque<Integer> path = new ArrayDeque<>();
        dfs(ans,0,path,used,len,nums);
        return ans;

    }

    private void dfs(List<List<Integer>> ans, int depth, Deque<Integer> path, boolean[] used, int len, int[] nums) {
        if(depth==len){
            ArrayList<Integer> temp = new ArrayList<>(path);
            ans.add(temp);
            return;
        }
        for (int i = 0; i < len; i++) {
            if(!used[i]){
                if(i>0&&nums[i]==nums[i-1]&&!used[i-1]){
                    continue;
                }
                used[i]=true;
                path.addLast(nums[i]);
                dfs(ans,depth+1,path,used,len,nums);
                path.removeLast();
                used[i]=false;
            }
        }
    }

}
