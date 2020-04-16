package lixuan.DataStructure.tree.order;

import lixuan.utils.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class postOrder {
    private List<Integer> res = new ArrayList<>();

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root != null) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            res.add(root.val);
        }
        return res;
    }

    /**
     * 非递归，判断是从左子树退出还是从右子树退出
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        TreeNode p = root, pre = null;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.peek();
            res.add(p.val);
            stack.pop();
            if (p.right == null || p.right == pre) {
                pre = p;
                p = null;//可以退到上一层
            } else {
                stack.push(p);
                res.remove(res.size() - 1);
                p = p.right;
            }
        }
        return res;
    }

    /**
     * 前序遍历为 root -> left -> right，后序遍历为 left -> right -> root。
     * 可以修改前序遍历成为 root -> right -> left，那么这个顺序就和后序遍历正好相反。
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) continue;
            ret.add(node.val);
            stack.push(node.left);
            stack.push(node.right);
        }
        Collections.reverse(ret);
        return ret;
    }
}
