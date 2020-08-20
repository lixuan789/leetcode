package lixuan.Backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 */
public class Code78Subsets {
    private List<List<Integer>> subsets=new ArrayList<>();
    private int n;
    public List<List<Integer>> subsets(int[] nums) {
        if (nums==null||nums.length==0){
            return subsets;
        }
        this.n=nums.length;
        for (int size=0;size<=n;size++){
            dfs(size,0,new ArrayList<Integer>(),nums);
        }
        return subsets;
    }

    private void dfs(int size, int start, ArrayList<Integer> subset, int[] nums) {
        if (size==subset.size()){
            subsets.add(new ArrayList<>(subset));
            return;
        }
        for (int i=start;i<n-(size-subset.size())+1;i++){
            subset.add(nums[i]);
            dfs(size,i+1,subset,nums);
            subset.remove(subset.size()-1);
        }
    }

    public static void main(String[] args) {
        Code78Subsets test = new Code78Subsets();
        int[] nums={1,2,3};
        List<List<Integer>> subsets = test.subsets(nums);
        for (List<Integer> temp:subsets){
            System.out.println(temp);
        }
    }
}
