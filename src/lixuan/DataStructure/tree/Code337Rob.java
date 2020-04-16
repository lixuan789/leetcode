package lixuan.DataStructure.tree;

import lixuan.utils.TreeNode;

public class Code337Rob {

    /**
     * 双重递归
     *
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int a = dfs(root);
        int b = rob(root.left) + rob(root.right);
        return Math.max(a, b);
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }

        if (root.left != null && root.right == null) {
            return root.val + rob(root.left.left) + rob(root.left.right);
        }
        if (root.left == null && root.right != null) {
            return root.val + rob(root.right.left) + rob(root.right.right);
        }
        return root.val + rob(root.left.left) + rob(root.left.right) + rob(root.right.left) + rob(root.right.right);
    }

    public int rob1(TreeNode root) {
        if (root == null) return 0;
        int val1 = root.val;
        if (root.left != null) val1 += rob(root.left.left) + rob(root.left.right);
        if (root.right != null) val1 += rob(root.right.left) + rob(root.right.right);
        int val2 = rob(root.left) + rob(root.right);
        return Math.max(val1, val2);
    }

    public int rob2(TreeNode root) {
        int[] ans = robHelper(root);
        return Math.max(ans[0], ans[1]);
    }

    private int[] robHelper(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] res = new int[2];
        int[] left = robHelper(root.left);
        int[] right = robHelper(root.right);
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];
        return res;
    }
}
