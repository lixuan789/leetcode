package lixuan.DataStructure.tree;

import lixuan.utils.TreeNode;

/**
 * 翻转一棵二叉树。
 */
public class Code226InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode left = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = left;
        return root;
    }
}
