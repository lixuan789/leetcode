package lixuan.interview;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    /**
     * 幂集：递归
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int size = 0; size <= n; size++) {
            dfs(0, ans, size, nums, new ArrayList<>());
        }
        return ans;
    }

    private void dfs(int index, List<List<Integer>> ans, int size, int[] nums, ArrayList<Integer> temp) {
        if (size == temp.size()) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            dfs(index+1, ans, size, nums, temp);
            temp.remove(temp.size() - 1);
        }
    }

    /**
     * 位运算
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets1(int[] nums) {
        //子集的长度是2的nums.length次方，这里通过移位计算
        int length = 1 << nums.length;
        List<List<Integer>> res = new ArrayList<>(length);
        //遍历从0到length中间的所有数字，根据数字中1的位置来找子集
        for (int i = 0; i < length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                //如果数字i的某一个位置是1，就把数组中对
                //应的数字添加到集合
                if (((i >> j) & 1) == 1)
                    list.add(nums[j]);
            }
            res.add(list);
        }
        return res;
    }
}
