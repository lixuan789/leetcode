package lixuan.daydayup;

import lixuan.utils.ListNode;

import java.util.List;

public class Code143ReorderList {
    /**
     * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
     * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
     *
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reorder-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param head
     */
    public void reorderList(ListNode head) {
        if (head==null||head.next==null){
            return;
        }
        ListNode slow=head;
        ListNode fast=head;
        ListNode pre=null;
        while (fast!=null&&fast.next!=null){
            pre=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        if (pre!=null){
            pre.next=null;
        }
        ListNode dummy=new ListNode(-1);
        while (slow!=null){
            ListNode next=slow.next;
            slow.next=dummy.next;
            dummy.next=slow;
            slow=next;
        }
        ListNode newHead=new ListNode(-1);
        ListNode p=newHead;
        ListNode p1=head;
        ListNode p2=dummy.next;
        while (p1!=null&&p2!=null){
            p.next=p1;
            p1=p1.next;
            p=p.next;
            p.next=p2;
            p2=p2.next;
            p=p.next;
        }
        if (p2!=null){
            p.next=p2;
        }
        head=newHead.next;
    }
}
