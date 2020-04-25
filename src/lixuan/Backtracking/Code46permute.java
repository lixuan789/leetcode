package lixuan.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Code46permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> paths = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return paths;
        }
        boolean[] visited = new boolean[nums.length];
        dfs(nums, visited, paths, new ArrayList<Integer>());
        return paths;
    }

    private void dfs(int[] nums, boolean[] visited, List<List<Integer>> paths, ArrayList<Integer> path) {
        if (path.size() == nums.length) {
            paths.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            path.add(nums[i]);
            dfs(nums, visited, paths, path);
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }
}
