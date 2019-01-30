package com.amazon;

import com.easy.linkedlist.ListNode;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 11/6/18
 * Talk is Cheap,Show me the Code.
 **/
public class SwapNodeInPairs24M {
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head;
        ListNode n1 = head.next;
        ListNode dummy = new ListNode(0);
        ListNode order = dummy;
        while (n1 != null) {
            ListNode n2 = n1.next;
            n1.next = cur;
            order.next = n1;
            order = cur;
            cur = n2;
            if (cur != null) {
                n1 = cur.next;
                if (n1 == null) {
                    order.next = cur;
                    order = order.next;
                }
            } else {
                n1 = null;
            }

        }
        order.next = null; //！！！否则最后两个元素会不断相互指来指去，memery out
        return dummy.next;
    }

    public static void main(String[] rags) {
        ListNode h = new ListNode(1);
        ListNode next = new ListNode(2);
        h.next = next;
        next.next = new ListNode(3);
        next.next.next = new ListNode(4);
        swapPairs(h);
    }
}
