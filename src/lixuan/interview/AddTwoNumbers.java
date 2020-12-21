package lixuan.interview;

import lixuan.utils.ListNode;

public class AddTwoNumbers {
    /**
     * 链表求和
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        int last = 0;
        while (p1 != null || p2 != null || last != 0) {
            int num1 = p1 == null ? 0 : p1.val;
            int num2 = p2 == null ? 0 : p2.val;
            int sum = num1 + num2 + last;
            p.next = new ListNode(sum % 10);//每次new 空间复杂度高
            last = sum / 10;
            if (p1 != null) {
                p1 = p1.next;
            }
            if (p2 != null) {
                p2 = p2.next;
            }
            p = p.next;
        }
        return dummy.next;
    }

    /**
     * 空间优化
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode pre = null;
        int last = 0;
        while (p1 != null || p2 != null || last != 0) {
            int num1 = p1 == null ? 0 : p1.val;
            int num2 = p2 == null ? 0 : p2.val;
            int sum = num1 + num2 + last;
            last = sum / 10;
            if (p1 != null) {
                p1.val = sum % 10;
            } else {
                p1 = new ListNode(sum % 10);
                pre.next = p1;
            }
            pre = p1;
            p1 = p1.next;
            if (p2 != null) {
                p2 = p2.next;
            }
        }
        return l1;
    }

    public static void main(String[] args) {
        AddTwoNumbers numbers = new AddTwoNumbers();
        ListNode l1 = new ListNode(-1);
        l1.next = new ListNode(1);
        ListNode l2 = new ListNode(-1);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        numbers.addTwoNumbers1(l1.next, l2.next);
    }
}
