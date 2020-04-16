package lixuan.daydayup;

import lixuan.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Code145PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
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
                p = null;
            } else {
                stack.push(p);
                res.remove(res.size() - 1);
                p = p.right;
            }
        }
        return res;
    }
}
