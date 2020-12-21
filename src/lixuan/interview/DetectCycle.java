package lixuan.interview;

import lixuan.utils.ListNode;

public class DetectCycle {
    /**
     * 环路检测
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                fast = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;

    }
}

