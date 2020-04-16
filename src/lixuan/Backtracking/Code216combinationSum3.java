package lixuan.Backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，
 * 并且每种组合中不存在重复的数字。
 * <p>
 * 说明：
 * <p>
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 */
public class Code216combinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> combinations = new ArrayList<List<Integer>>();
        if (k <= 0 || n <= 0) {
            return combinations;
        }
        dfs(combinations, new ArrayDeque<Integer>(), 1, k, n);
        return combinations;
    }

    private void dfs(List<List<Integer>> combinations, ArrayDeque<Integer> path, int start, int k, int target) {
        if (target == 0 && k == 0) {
            combinations.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= 9 - k + 1; i++) {
            if (i <= target) {
                path.addLast(i);
                dfs(combinations, path, i + 1, k - 1, target - i);
                path.removeLast();
            }
        }
    }
}
