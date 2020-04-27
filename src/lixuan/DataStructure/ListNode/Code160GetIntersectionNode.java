package lixuan.DataStructure.ListNode;

import lixuan.utils.ListNode;

/**
 * 链表相交
 * 如果只是判断是否存在交点
 *      1.把第一个链表的结尾连接到第二个链表的开头，看第二个链表是否存在环
 *      2.或者直接比较两个链表的最后一个节点是否相同
 */
public class Code160GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            if (a == null) {
                a = headB;
            } else {
                a = a.next;
            }
            if (b == null) {
                b = headA;
            } else {
                b = b.next;
            }
        }
        return a;
    }
}
