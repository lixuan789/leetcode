package lixuan.interview;

import lixuan.utils.TreeNode;

import java.util.Stack;

/**
 * 实现一个函数，检查一棵二叉树是否为二叉搜索树。
 */
public class isValidBST {
    TreeNode pre = null;

    boolean ans = true;

    /**
     * 中序遍历有序：①递归 ②非递归
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre != null && root.val <= pre.val) {
            ans = false;
            return;
        }
        pre = root;
        dfs(root.right);
    }

    /**
     * 中序遍历非递归
     *
     * @param root
     * @return
     */
    public boolean isValidBST1(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (!stack.isEmpty() || p != null) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            TreeNode cur = stack.pop();
            if (pre != null && cur.val <= pre.val) {
                return false;
            }
            pre = cur;
            p = cur.right;
        }
        return true;
    }
}
