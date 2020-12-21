package lixuan.interview;

import lixuan.utils.ListNode;

public class Partition {
    /**
     * 编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。
     * 如果链表中包含 x，x 只需出现在小于 x 的元素之后(如下所示)。分割元素 x 只需处于“右半部分”即可，其不需要被置于左右两部分之间。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/partition-list-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode left = new ListNode(-1);
        ListNode leftHead = left;
        ListNode right = new ListNode(-1);
        ListNode rightHead = right;
        ListNode p = head;
        while (p != null) {
            ListNode next = p.next;
            p.next = null;
            if (p.val < x) {
                left.next = p;
                left = p;
            } else {
                right.next = p;
                right = p;
            }
            p = next;
        }
        left.next = rightHead.next;
        return leftHead.next;
    }


    public ListNode partition1(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head, pre = head;
        while (cur != null) {
            if (cur.val < x) {
                int temp = cur.val;
                cur.val = pre.val;
                pre.val = temp;
                pre = pre.next;
            }
            cur = cur.next;
        }
        return head;
    }

}
