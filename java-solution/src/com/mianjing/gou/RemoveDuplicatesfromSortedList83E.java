package com.mianjing.gou;

import com.easy.linkedlist.ListNode;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/7/19
 * Talk is Cheap,Show me the Code.
 **/
public class RemoveDuplicatesfromSortedList83E {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while(cur != null && cur.next != null){
            if(cur.val == cur.next.val){
                ListNode tmp = cur.next;
                cur.next = cur.next.next;
                tmp.next = null;
            }else{
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args){
      RemoveDuplicatesfromSortedList83E t = new RemoveDuplicatesfromSortedList83E();
        ListNode h  = new ListNode(1);
        ListNode one = h.next = new ListNode(1);
        one.next = new ListNode(2);
        t.deleteDuplicates(h);
        System.out.println();
    }
}
