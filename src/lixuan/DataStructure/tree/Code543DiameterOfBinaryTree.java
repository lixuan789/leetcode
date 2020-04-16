package lixuan.DataStructure.tree;

import lixuan.utils.TreeNode;

public class Code543DiameterOfBinaryTree {
    private int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return res;
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        int num = leftDepth + rightDepth;
        res = Math.max(res, num);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
