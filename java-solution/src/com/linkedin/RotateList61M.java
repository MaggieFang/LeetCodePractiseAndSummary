package com.linkedin;

import com.basic.ListNode;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-09-08
 **/
public class RotateList61M {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * This question just need to move the last K node to the left  part.
     * firstly, count the number of the total. recompute k = k % count, if k == 0; no need to move.
     * otherwise, we need to compute the new head position, easy, count - k; travel the link to it.
     * then travel to the end, make end.next = head. done
     * </p>
     * TIME COMPLEXITY: O(n)
     * SPACE COMPLEXITY:O(1)
     * </p>
     **/
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        ListNode node = head;
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }

        k = k % count;
        if (k == 0) return head;

        int diff = count - k;
        node = head;
        ListNode pre = null;
        while (diff-- > 0) {
            pre = node;
            node = node.next;
        }
        pre.next = null; //don't forget!!
        ListNode end = node;
        while (end.next != null) {
            end = end.next;
        }
        end.next = head;
        return node;

    }
}
