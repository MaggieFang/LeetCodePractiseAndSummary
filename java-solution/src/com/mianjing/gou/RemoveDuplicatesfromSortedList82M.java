package com.mianjing.gou;

import com.easy.linkedlist.ListNode;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/7/19
 * Talk is Cheap,Show me the Code.
 **/
public class RemoveDuplicatesfromSortedList82M {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        ListNode unique = null;

        while (cur != null && cur.next != null) {
            if (cur.val != cur.next.val) {
                unique = cur;
                cur = cur.next;
            } else {
                while (cur != null && cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                ListNode p = cur;
                cur = cur.next;

                if (unique == null) { // 1->1->1->1->2
                    head = cur;
                } else {
                    unique.next = cur;

                }
                p.next = null;
            }
        }
        return head;
    }
}
