package com.fb;

import com.easy.linkedlist.ListNode;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/1/18
 * Talk is Cheap,Show me the Code.
 **/
public class AddTwoNum2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode node = new ListNode(-1);
        ListNode head = node;
        int carry = 0;
        while (l1 != null || l2 != null) {
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
