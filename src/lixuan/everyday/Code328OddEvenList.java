package lixuan.everyday;

import lixuan.utils.ListNode;


public class Code328OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;
        while (even != null) {
            if (even.next == null) {
                odd.next = evenHead;
                return head;
            } else {
                odd.next = even.next;
                odd = odd.next;
            }
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
