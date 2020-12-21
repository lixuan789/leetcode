package lixuan.interview;

import lixuan.utils.TreeNode;

/**
 * 面试题 04.10. 检查子树
 */
public class CheckSubTree {
    /**
     * 递归
     * @param t1
     * @param t2
     * @return
     */
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        if (t1.val == t2.val) {
            return checkSubTree(t1.left, t2.left) && checkSubTree(t1.right, t2.right);
        }
        return checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);
    }
}
