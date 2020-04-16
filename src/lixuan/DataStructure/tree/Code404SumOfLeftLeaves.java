package lixuan.DataStructure.tree;

import lixuan.utils.TreeNode;

/**
 * 计算给定二叉树的所有左叶子之和。
 */
public class Code404SumOfLeftLeaves {
    /**
     * 前序遍历递归
     *
     * @param root
     * @return
     */
    private int res = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        preOrder(root);
        return res;

    }
    private void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        if (root != null && root.left != null && root.left.left == null && root.left.right == null) {
            res += root.left.val;
        }
        preOrder(root.left);
        preOrder(root.right);
    }
}
