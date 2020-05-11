package lixuan.daydayup;

import lixuan.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 */
public class Code27mirrorTree {
    /**
     * 递归
     * @param root
     * @return
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root != null) {
            TreeNode left = mirrorTree(root.left);
            root.left = mirrorTree(root.right);
            root.right = left;
        }
        return root;
    }

    /**
     * 非递归
     * @param root
     * @return
     */
    public TreeNode mirrorTree1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node==null){
                continue;
            }
            TreeNode temp=node.left;
            node.left=node.right;
            node.right=temp;
            queue.offer(node.left);
            queue.offer(node.right);
        }
        return root;
    }
}
