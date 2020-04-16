package lixuan.daydayup;

import lixuan.utils.ListNode;

import java.util.List;

/**
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 * <p>
 * 如果有两个中间结点，则返回第二个中间结点。
 */
public class Code876middleNode {
    public ListNode middleNode(ListNode head) {
        int len = 0;
        ListNode p = head;
        while (p != null) {
            len++;
            p = p.next;
        }
        int mid = len / 2;
        ListNode q = head;
        for (int i = 0; i < mid; i++) {
            q = q.next;
        }
        return q;
    }

    /**
     * 优化：快慢指针
     *
     * @param head
     * @return
     */
    public ListNode middleNode1(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
