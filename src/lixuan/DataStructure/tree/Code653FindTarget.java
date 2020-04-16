package lixuan.DataStructure.tree;

import lixuan.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉搜索树和一个目标结果，
 * 如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 */
public class Code653FindTarget {
    /**
     * 使用中序遍历得到有序数组之后，再利用双指针对数组进行查找。
     * 应该注意到，这一题不能用分别在左右子树两部分来处理这种思想，
     * 因为两个待求的节点可能分别在左右子树中。
     * @param root
     * @param k
     * @return
     */
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> nums = new ArrayList<>();
        inOrder(root, nums);
        int i = 0, j = nums.size() - 1;
        while (i < j) {
            int sum = nums.get(i) + nums.get(j);
            if (sum == k) return true;
            if (sum < k) i++;
            else j--;
        }
        return false;
    }

    private void inOrder(TreeNode root, List<Integer> nums) {
        if (root == null) return;
        inOrder(root.left, nums);
        nums.add(root.val);
        inOrder(root.right, nums);
    }
}
