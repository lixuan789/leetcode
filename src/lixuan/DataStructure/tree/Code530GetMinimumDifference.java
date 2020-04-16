package lixuan.DataStructure.tree;

import lixuan.utils.TreeNode;

import java.util.ArrayList;

/**
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 */
public class Code530GetMinimumDifference {
    public int getMinimumDifference(TreeNode root) {
        ArrayList<Integer> nums = new ArrayList<>();
        Inorder(root, nums);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < nums.size(); i++) {
            int temp = Math.abs(nums.get(i) - nums.get(i - 1));
            min = Math.min(min, temp);
        }
        return min;
    }

    private void Inorder(TreeNode root, ArrayList<Integer> nums) {
        if (root == null) return;
        Inorder(root.left, nums);
        nums.add(root.val);
        Inorder(root.right, nums);
    }

    private int minDiff = Integer.MAX_VALUE;
    private TreeNode preNode = null;

    /**
     * 优化
     * @param root
     * @return
     */
    public int getMinimumDifference1(TreeNode root) {
        inOrder(root);
        return minDiff;
    }

    private void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        if (preNode != null) minDiff = Math.min(minDiff, node.val - preNode.val);
        preNode = node;
        inOrder(node.right);
    }
}
