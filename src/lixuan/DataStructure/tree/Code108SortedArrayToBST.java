package lixuan.DataStructure.tree;

import lixuan.utils.TreeNode;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 */
public class Code108SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return bulider(nums, 0, nums.length - 1);
    }

    private TreeNode bulider(int[] nums, int l, int h) {
        if (l > h) {
            return null;
        }
        int mid = l + (h - l) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = bulider(nums, l, mid - 1);
        root.right = bulider(nums, mid + 1, h);
        return root;
    }
}
