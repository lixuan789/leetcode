package lixuan.daydayup;

import lixuan.utils.TreeNode;

/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 */
public class Code106BuildTree {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) {
            return null;
        }
        int n = inorder.length;
        TreeNode root = buildTree(inorder, 0, n - 1, postorder, 0, n - 1);
        return root;
    }

    private TreeNode buildTree(int[] in, int is, int ie, int[] po, int pi, int pe) {
        if (is > ie || pi > pe) {
            return null;
        }
        int num = po[pe];
        int len = 0;
        for (int i = is; i <= ie; i++) {
            if (in[i] == num) {
                break;
            }
            len++;
        }
        TreeNode root = new TreeNode(num);
        root.left = buildTree(in, is, is + len - 1, po, pi, pi + len - 1);
        root.right = buildTree(in, is + len + 1, ie, po, pi + len, pe - 1);
        return root;
    }


}
