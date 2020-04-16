package lixuan.DataStructure.tree;

import lixuan.utils.TreeNode;

public class Code572IsSubtree {
    /**
     * 双重递归
     * @param s
     * @param t
     * @return
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        return judgeSubtree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean judgeSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        }
        return judgeSubtree(s.left, t.left) && judgeSubtree(s.right, t.right);
    }
}
