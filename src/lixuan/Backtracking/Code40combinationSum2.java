package lixuan.Backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为
 * target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 */
public class Code40combinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0) {
            return combinations;
        }
        int len = candidates.length;
        Arrays.sort(candidates);
        dfs(candidates, combinations, new boolean[len], new ArrayDeque<Integer>(), 0, target);
        return combinations;
    }

    private void dfs(int[] candidates, List<List<Integer>> combinations, boolean[] visited, ArrayDeque<Integer> path, int start, int target) {
        if (target == 0) {
            combinations.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (!visited[i]) {
                if (i > 0 && candidates[i] == candidates[i - 1] && visited[i - 1] == false) {
                    continue;
                }
                if (candidates[i] <= target) {
                    visited[i] = true;
                    path.addLast(candidates[i]);
                    dfs(candidates, combinations, visited, path, i + 1, target - candidates[i]);
                    path.removeLast();
                    visited[i] = false;
                }
            }
        }
    }
}
