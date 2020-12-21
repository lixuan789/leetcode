package lixuan.everyday;

import lixuan.utils.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Code147InsertionSortList {
    /**
     * 对链表进行插入排序。
     *
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        List<Integer> list = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            list.add(p.val);
            p = p.next;
        }
        Integer[] array = list.toArray(new Integer[list.size()]);
        for (int i = 1; i < array.length; i++) {
            if (array[i] >= array[i - 1]) {
                continue;
            }
            int num = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > num) {
                array[j + 1] = array[j];//后移
                j--;
            }
            array[j + 1] = num;
        }
        int index = 0;
        p = head;
        while (p != null) {
            p.val = array[index++];
            p = p.next;
        }
        return head;
    }

    /**
     * 链表操作
     *
     * @param head
     * @return
     */
    public ListNode insertionSortList1(ListNode head) {
        ListNode dummy = new ListNode(0), pre;
        dummy.next = head;
        while (head != null && head.next != null) {
            if (head.val <= head.next.val) {
                head = head.next;
                continue;
            }
            pre = dummy;

            while (pre.next.val < head.next.val) pre = pre.next;

            ListNode curr = head.next;
            head.next = curr.next;
            curr.next = pre.next;
            pre.next = curr;
        }
        return dummy.next;
    }
}
