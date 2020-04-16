package lixuan.DataStructure.tree;

import lixuan.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 */
public class Code101IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        return helper(root, root);
    }

    private boolean helper(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return helper(root1.left, root2.right) && helper(root1.right, root2.left);
    }

    /**
     * 中序遍历是回文数(满二叉树才可以)
     *
     * @param root
     * @return
     */
    public boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<String> list = new LinkedList<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            TreeNode node = stack.pop();
            list.add(node.val + "");
            if (node.left != null && node.right == null) {
                list.add("#");
            }
            if (node.left == null && node.right != null) {
                list.removeLast();
                list.add("#");
                list.add(node.val + "");
            }
            p = node.right;
        }
        while (list.size() > 1) {
            String head = list.pollFirst();
            String tail = list.removeLast();
            if (head.equals(tail)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 层序遍历
     *
     * @param root
     * @return
     */
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node1 = queue.poll();
                TreeNode node2 = queue.poll();
                if (node1 == null && node2 == null) {
                    continue;
                }
                if (node1 == null || node2 == null) {
                    return false;
                }
                if (node1.val != node2.val) {
                    return false;
                }
                queue.add(node1.left);
                queue.add(node2.right);
                queue.add(node1.right);
                queue.add(node2.left);
            }
        }
        return true;
    }
}
