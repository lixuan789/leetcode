package lixuan.daydayup;

import lixuan.utils.ListNode;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class Code24SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre=dummy;
        ListNode odd = head;
        ListNode even = head.next;
        while (even != null) {
            odd.next = even.next;
            even.next = odd;
            pre.next=even;
            pre=odd;
            odd = odd.next;
            if (odd==null)break;
            even = odd.next;
        }
        return dummy.next;
    }

}
