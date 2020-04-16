package lixuan.Backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,2]
 * 输出:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 */
public class Code90subsetsWithDup {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> combinations = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return combinations;
        }
        int n = nums.length;
        Arrays.sort(nums);
        for (int size = 0; size <= n; size++) {
            dfs(nums, combinations, new ArrayDeque<Integer>(), new boolean[n], size, 0);
        }
        return combinations;
    }

    private void dfs(int[] nums, List<List<Integer>> combinations, ArrayDeque<Integer> path, boolean[] visited, int size, int start) {
        if (path.size() == size) {
            combinations.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (!visited[i]) {
                if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                    continue;
                }
                visited[i] = true;
                path.addLast(nums[i]);
                dfs(nums, combinations, path, visited, size, start + 1);
                visited[i] = false;
                path.removeLast();
            }
        }
    }
}
