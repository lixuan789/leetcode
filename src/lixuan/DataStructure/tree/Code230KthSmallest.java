package lixuan.DataStructure.tree;

import lixuan.utils.TreeNode;

/**
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 * <p>
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code230KthSmallest {
    private int index = 0;
    private int res = 0;

    public int kthSmallest(TreeNode root, int k) {
        Inorder(root, k);
        return res;
    }

    private void Inorder(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        Inorder(root.left, k);
        index++;
        if (index == k) {
            res = root.val;
            return;
        }
        Inorder(root.right, k);
    }

    /**
     * 经典
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest1(TreeNode root, int k) {
        int leftCnt = count(root.left);
        if (leftCnt == k - 1) return root.val;
        if (leftCnt > k - 1) return kthSmallest(root.left, k);
        return kthSmallest(root.right, k - leftCnt - 1);
    }

    private int count(TreeNode node) {
        if (node == null) return 0;
        return 1 + count(node.left) + count(node.right);
    }
}
