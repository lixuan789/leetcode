package lixuan.DataStructure.tree;

import lixuan.utils.ListNode;
import lixuan.utils.TreeNode;

import java.util.ArrayList;

/**
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code109SortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        int[] nums = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
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

    /**
     * 用两个指针，一块一慢，快的每次走两步，慢的每次走一步，这样当快指针遍历结束时，
     * 慢指针指向的也就是链表的中间位置。这时候把中间位置的结点的值作为二叉搜索树当前结点的值
     * @param head
     * @return
     */
    public TreeNode sortedListToBST1(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        ListNode preMid = preMid(head);
        ListNode mid = preMid.next;
        preMid.next = null;  // 断开链表
        TreeNode t = new TreeNode(mid.val);
        t.left = sortedListToBST(head);
        t.right = sortedListToBST(mid.next);
        return t;
    }
    private ListNode preMid(ListNode head) {
        ListNode slow = head, fast = head;
        ListNode pre = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return pre;
    }
}
