package lixuan.DataStructure.ListNode;

import lixuan.utils.ListNode;

public class Code28DeleteDuplicates {
    /**
     * 重复的节点全删
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy, cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                pre.next = cur.next;
                cur = cur.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return dummy.next;
    }


    /**
     * 重复节点留一个
     * @param head
     * @return
     */
    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode r = head;
        ListNode p = head.next;
        while (p != null) {
            if (p.val == r.val) {
                p = p.next;
            } else {
                r.next = p;
                r = p;
                p = p.next;
            }
        }
        r.next = null;
        return dummy.next;
    }

}
