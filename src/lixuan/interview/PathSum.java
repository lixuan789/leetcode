package lixuan.interview;

import lixuan.utils.TreeNode;

public class PathSum {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int dfs(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum -= root.val;
        int count = sum == 0 ? 1 : 0;
        count += dfs(root.left, sum - root.val);
        count += dfs(root.right, sum - root.val);
        return count;
    }
}
