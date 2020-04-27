package lixuan.DataStructure.ListNode;

import lixuan.utils.ListNode;


/**
 * 请判断一个链表是否为回文链表。
 */
public class Code234isPalindrome {
    /**
     * 分成两半，后一半用头插法逆序
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = null;
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = dummy.next;
            dummy.next = slow;
            slow = next;
        }
        ListNode newHead = dummy.next;
        while (head != null && newHead != null) {
            if (head.val != newHead.val) {
                return false;
            }
            head = head.next;
            newHead = newHead.next;
        }
        return true;
    }
}
