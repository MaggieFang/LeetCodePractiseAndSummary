package com.easy.linkedlist;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 9/19/18
 * Talk is Cheap,Show me the Code.
 **/
public class MergeTwoSortedLink21 {
    /**
     * KEYPOINTS:
     * <p>
     *  add a dummy node preHead, then get the smaller node the connect every time.
     * <p>
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY: O(l1.size+l2.size)
     * <p>
     * SPACE COMPLEXITY: O(1)
     * <p>
     **/
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode preHead = new ListNode(0);
        ListNode node  = preHead;
        while(l1 != null && l2 != null){// 分成这样&&跟后面的单独拼接两步 比用 || 好一些，毕竟后面拼接不用一个个遍历
            int v1 = l1.val;
            int v2 = l2.val;
            if(v1 < v2){
                node.next = l1;
                l1 = l1.next;
                node = node.next;
            }else{
                node.next = l2;
                l2 = l2.next;
                node = node.next;
            }
        }

        if(l1 != null){
            node.next = l1;// joint directly
        }
        if(l2 != null){
            node.next = l2;
        }
        return preHead.next;
    }


    public ListNode mergeTwoListsRecurrence(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if(l1.val < l2.val){
            l1.next = mergeTwoListsRecurrence(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoListsRecurrence(l1,l2.next);
            return l2;
        }
    }

}
