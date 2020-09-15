package lixuan.DataStructure.ListNode;

import lixuan.utils.ListNode;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 */
public class Code19RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode fast = head;
        while (n-- > 1) {
            fast = fast.next;
        }
        ListNode slow = head;
        ListNode pre = null;//slow的前驱节点
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next;
        }
        if (slow == head) {//如果为头结点
            head = head.next;
        } else {
            pre.next = slow.next;
        }
        return head;
    }
}
