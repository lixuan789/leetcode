package lixuan.DataStructure.ListNode;

import lixuan.utils.ListNode;

/**
 * 给定一个头结点为 root 的链表, 编写一个函数以将链表分隔为 k 个连续的部分。
 * <p>
 * 每部分的长度应该尽可能的相等: 任意两部分的长度差距不能超过 1，也就是说可能有些部分为 null。
 * <p>
 * 这k个部分应该按照在链表中出现的顺序进行输出，并且排在前面的部分的长度应该大于或等于后面的长度。
 * <p>
 * 返回一个符合上述规则的链表的列表。
 * <p>
 * 举例： 1->2->3->4, k = 5 // 5 结果 [ [1], [2], [3], [4], null ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-linked-list-in-parts
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code725SplitListToParts {
    public ListNode[] splitListToParts(ListNode root, int k) {
        int len = 0;
        ListNode p = root;
        ListNode[] res = new ListNode[k];
        while (p != null) {
            len++;
            p = p.next;
        }
        int base = len / k;
        int mod = len % k;
        p = root;
        for (int i = 0; i < k; i++) {
            int count = base;
            if (i < mod) {
                count += 1;
            }
            ListNode start = p;
            for (int j = 0; j < count - 1; j++) {
                p = p.next;
            }
            if (p != null) {
                ListNode next = p.next;
                p.next = null;
                res[i] = start;
                p = next;
            } else {
                res[i] = null;
            }
        }
        return res;
    }
}
