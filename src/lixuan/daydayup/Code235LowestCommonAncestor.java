package lixuan.daydayup;

import lixuan.utils.TreeNode;

public class Code235LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (root.val > p.val && root.val < q.val) {
            return root;
        }
        if (root.val < p.val && root.val > q.val) {
            return root;
        }
        return null;
    }
}
