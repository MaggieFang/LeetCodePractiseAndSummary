package com.ms;

import com.basic.ListNode;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-08-30
 **/
public class AddTwoNumbersII445M {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * revert the linked, and use AddTwoNumbers2M.
     * </p>
     * TIME COMPLEXITY: O(n+m)
     * SPACE COMPLEXITY: O(1)
     * </p>
     **/
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = revertLink(l1);
        l2 = revertLink(l2);
        ListNode res = addTwoNumbers2(l1, l2);
        return revertLink(res);

    }

    private ListNode revertLink(ListNode l) {
        if (l == null || l.next == null) return l;
        ListNode pre = null;
        ListNode cur = l;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode node = new ListNode(-1);
        ListNode head = node;
        int carry = 0;
        while (l1 != null || l2 != null) { // or is better, otherwise, I need two more while to do the similar thing for l1 and l2.
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum / 10;
            node.next = new ListNode(sum % 10);
            node = node.next;

        }
        if (carry != 0) {
            node.next = new ListNode(carry);
        }
        return head.next;

    }
}
