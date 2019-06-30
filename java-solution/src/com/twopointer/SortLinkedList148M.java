package com.twopointer;

import com.basic.ListNode;
/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-06-29
 **/
public class SortLinkedList148M {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * it requires O(nlogn),for sort, we will consider quickSort,mergeSort.Heapsort.
     * For linkedList,It seems better to use mergeSort.which merge two sorted list.
     * how? when two lists each has only one node
     *
     *  we can continue use Divide and Conquer to make a unsorted listed into two until there is only one node in each list.
     *
     *  How to break a linkedList into two? fast-slow pointer can help. when the fast to the end, the slow is on the mid.
     *
     * </p>
     * TIME COMPLEXITY: O(NlogN)
     * SPACE COMPLEXITY: O(1)
     * </p>
     **/
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head, pre = slow;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        pre.next = null;
        return merge(sortList(head), sortList(slow));
    }

    private ListNode merge(ListNode h1, ListNode h2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (h1 != null && h2 != null) {
            if (h1.val < h2.val) {
                cur.next = h1;
                h1 = h1.next;
            } else {
                cur.next = h2;
                h2 = h2.next;
            }
            cur = cur.next;
        }
        while (h1 != null) {
            cur.next = h1;
            h1 = h1.next;
            cur = cur.next;
        }

        while (h2 != null) {
            cur.next = h2;
            h2 = h2.next;
            cur = cur.next;
        }

        return dummy.next;
    }
}
