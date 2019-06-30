package com.linkedList;

import com.basic.ListNode;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-06-30
 **/
public class InsertionSortList147M {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * use a dummy node will make work easy.
     *
     * </p>
     * TIME COMPLEXITY: O(n^2)
     * SPACE COMPLEXITY: O(1)
     * </p>
     **/
    public ListNode insertionSortList(ListNode head) {
        //  if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            ListNode sorted = dummy; //good
            while (sorted.next != null && sorted.next.val <= cur.val) {
                sorted = sorted.next;
            }
            cur.next = sorted.next; // !!! take care.
            sorted.next = cur;

            cur = next;
        }
        return dummy.next;
    }
}
