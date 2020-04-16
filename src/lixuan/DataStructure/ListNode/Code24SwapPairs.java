package lixuan.DataStructure.ListNode;

import lixuan.utils.ListNode;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class Code24SwapPairs {
    /**
     * 模拟迭代
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode one = head;
        ListNode two = head.next;
        while (two != null) {
            one.next = two.next;
            two.next = pre.next;
            pre.next = two;
            pre = one;
            if (pre != null) {
                one = pre.next;
            } else {
                one = null;
            }
            if (one != null) {
                two = one.next;
            } else {
                two = null;
            }
        }
        return dummy.next;
    }

    /**
     * 优化：可读性好
     * @param head
     * @return
     */
    public ListNode swapPairs2(ListNode head) {
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode pre = node;
        while (pre.next != null && pre.next.next != null) {
            ListNode l1 = pre.next, l2 = pre.next.next;
            ListNode next = l2.next;
            l1.next = next;
            l2.next = l1;
            pre.next = l2;
            pre = l1;
        }
        return node.next;
    }

    /**
     * 递归
     * @param head
     * @return
     */
    public ListNode swapPairs1(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }
}
