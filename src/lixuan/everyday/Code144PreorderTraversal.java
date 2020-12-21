package lixuan.everyday;

import lixuan.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 树的前序遍历
 */
public class Code144PreorderTraversal {
    private List<Integer> ans = new ArrayList<>();

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return null;
        }
        ans.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return ans;
    }

    /**
     * 迭代
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        if (root == null) {
            return ans;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        stack.push(p);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ans.add(node.val);
            if (node.right!=null){
                stack.push(node.right);
            }
            if (node.left!=null){
                stack.push(node.left);
            }
        }
        return ans;
    }
}
