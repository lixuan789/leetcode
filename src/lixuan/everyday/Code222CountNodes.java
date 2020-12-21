package lixuan.everyday;

import lixuan.utils.TreeNode;

public class Code222CountNodes {
    /**
     * 普通树暴力解法
     *
     * @param root
     * @return
     */
    public int countNodes1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countNodes1(root.left) + countNodes1(root.right) + 1;
    }

    /**
     * 利用完全二叉树的性质
     *
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = countLevel(root.left);
        int right = countLevel(root.right);
        if (left == right) {//左右高度相等，则左子树满
            return countNodes(root.right) + (1 << left);
        } else {//左右高度不相等，则右子树满
            return countNodes(root.left) + (1 << right);
        }
    }

    private int countLevel(TreeNode root) {
        int level = 0;
        while (root != null) {
            level++;
            root = root.left;
        }
        return level;
    }
}
