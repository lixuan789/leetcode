package lixuan.DataStructure.tree;

import lixuan.utils.TreeNode;

public class Code112hHasPathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                return true;
            } else {
                return false;
            }
        }
        if (hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val)) {
            return true;
        } else {
            return false;
        }
    }
}
