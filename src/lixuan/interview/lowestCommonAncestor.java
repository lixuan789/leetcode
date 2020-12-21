package lixuan.interview;

import lixuan.utils.TreeNode;

/**
 * 二叉树首个共同祖先
 */
public class lowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        if (left != null && right == null) {
            return left;
        }
        return right;
    }
}
