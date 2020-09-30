package lixuan.DataStructure.tree;

import lixuan.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 翻转一棵二叉树。
 */
public class Code226InvertTree {
    /**
     * 递归
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode left = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = left;
        return root;
    }

    /**
     * 层序遍历
     *
     * @param root
     * @return
     */
    public TreeNode invertTree1(TreeNode root) {
        if (root == null) {
            return root;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode res = root;
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            while (len-- > 0) {
                TreeNode node = queue.poll();
                if (node != null) {
                    TreeNode left = node.left;
                    node.left = node.right;
                    node.right = left;
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
        }
        return res;
    }
}
