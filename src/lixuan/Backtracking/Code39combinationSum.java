package lixuan.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Code39combinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        backtracking(new ArrayList<>(), combinations, 0, target, candidates);
        return combinations;
    }

    private void backtracking(List<Integer> tempCombination, List<List<Integer>> combinations,
                              int start, int target, final int[] candidates) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            combinations.add(new ArrayList<>(tempCombination));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                tempCombination.add(candidates[i]);
                backtracking(tempCombination, combinations, i, target - candidates[i], candidates);//从i开始，数字可以重复用
                tempCombination.remove(tempCombination.size() - 1);
            }
        }
    }
}
