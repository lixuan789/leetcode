package lixuan.DataStructure.ListNode;

import lixuan.utils.ListNode;

import java.util.Stack;

public class Code445AddTwoNumbers {
    /**
     * 装换为数字再头插法,数字溢出
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long numa = listToNum(l1);
        long numb = listToNum(l2);
        long num = numa + numb;
        if (num == 0) {
            return new ListNode(0);
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = null;
        while (num != 0) {
            ListNode node = new ListNode((int) num % 10);
            node.next = dummy.next;
            dummy.next = node;
            num /= 10;
        }
        return dummy.next;
    }

    private long listToNum(ListNode l2) {
        long num = 0;
        while (l2 != null) {
            num = num * 10 + l2.val;
            l2 = l2.next;
        }
        return num;
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode rev1 = reverse(l1);
        ListNode rev2 = reverse(l1);
        ListNode dummy = new ListNode(-1);
        dummy.next = null;
        int carry = 0;
        while (rev1 != null || rev2 != null || carry != 0) {
            int num1 = (rev1 == null) ? 0 : rev1.val;
            int num2 = (rev2 == null) ? 0 : rev2.val;
            int num = num1 + num2 + carry;
            ListNode node = new ListNode(num % 10);
            carry = num / 10;
            node.next = dummy.next;
            dummy.next = node;
            if (rev1 != null) {
                rev1 = rev1.next;
            }
            if (rev2 != null) {
                rev2 = rev2.next;
            }
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode l) {
        ListNode dummy = new ListNode(-1);
        while (l != null) {
            ListNode next = l.next;
            l.next = dummy.next;
            dummy.next = l;
            l = next;
        }
        return dummy.next;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        Stack<Integer> l1Stack = buildStack(l1);
        Stack<Integer> l2Stack = buildStack(l2);
        ListNode head = new ListNode(-1);
        int carry = 0;
        while (!l1Stack.isEmpty() || !l2Stack.isEmpty() || carry != 0) {
            int x = l1Stack.isEmpty() ? 0 : l1Stack.pop();
            int y = l2Stack.isEmpty() ? 0 : l2Stack.pop();
            int sum = x + y + carry;
            ListNode node = new ListNode(sum % 10);
            node.next = head.next;
            head.next = node;
            carry = sum / 10;
        }
        return head.next;
    }

    private Stack<Integer> buildStack(ListNode l) {
        Stack<Integer> stack = new Stack<>();
        while (l != null) {
            stack.push(l.val);
            l = l.next;
        }
        return stack;
    }
}
