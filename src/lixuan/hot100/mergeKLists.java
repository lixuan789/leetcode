package lixuan.hot100;

import lixuan.utils.ListNode;

public class mergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null){
            return null;
        }
        if (lists.length==1){
            return lists[0];
        }
        if (lists.length==2){
            return merge(lists[0],lists[1]);
        }
        int mid=lists.length/2;
        ListNode[] list1=new ListNode[mid];
        for (int i=0;i<mid;i++){
            list1[i]=lists[i];
        }
        ListNode[] list2=new ListNode[lists.length-mid];
        for (int i=mid;i<lists.length;i++){
            list2[i-mid]=lists[mid];
        }
        return merge(mergeKLists(list1),mergeKLists(list2));
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1==null){
            return l2;
        }
        if (l2==null){
            return l1;
        }
        if (l1.val<l2.val){
            l1.next=merge(l1.next,l2);
            return l1;
        }else {
            l2.next=merge(l1,l2.next);
            return l2;
        }
    }
}
