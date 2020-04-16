package lixuan.test.test2;

import lixuan.utils.TreeNode;

/**
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 * <p>
 * 二叉树的根是数组中的最大元素。
 * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 */
public class constructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int s, int e) {
        if (s > e) {
            return null;
        }
        int maxNum = Integer.MIN_VALUE;
        int index = s;
        for (int i = s; i <= e; i++) {
            if (nums[i] > maxNum) {
                maxNum = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(maxNum);
        root.left = helper(nums, s, index - 1);
        root.right = helper(nums, index + 1, e);
        return root;
    }
}
