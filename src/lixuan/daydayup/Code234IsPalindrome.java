package lixuan.daydayup;

import lixuan.utils.ListNode;

public class Code234IsPalindrome {
    /**
     * 请判断一个链表是否为回文链表。
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast == null) {
            if (pre != null) {
                pre.next = null;
            }
        } else {
            ListNode next = slow.next;
            slow.next = null;
            slow = next;
        }
        ListNode dummy = new ListNode(-1);
        while (slow != null) {
            ListNode temp = slow.next;
            slow.next = dummy.next;
            dummy.next = slow;
            slow = temp;
        }
        ListNode p = head;
        ListNode q = dummy.next;
        while (q != null) {
            if (p.val != q.val) {
                return false;
            }
            p = p.next;
            q = q.next;
        }
        return true;
    }
}
