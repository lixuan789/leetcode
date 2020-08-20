package lixuan.daydayup;

import lixuan.utils.ListNode;
import lixuan.utils.TreeNode;

import java.util.ArrayList;

/**
 * 有序链表转换二叉搜索树
 */
public class Code109SortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] nums = new int[list.size()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i);
        }
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int s, int e) {
        if (s > e) {
            return null;
        }
        int mid = s + (e - s) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums, s, mid - 1);
        root.right = buildTree(nums, mid + 1, e);
        return root;
    }
}
