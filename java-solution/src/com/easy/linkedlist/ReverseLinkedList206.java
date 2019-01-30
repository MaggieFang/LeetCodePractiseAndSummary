package com.easy.linkedlist;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 9/19/18
 * Talk is Cheap,Show me the Code.
 **/
public class ReverseLinkedList206 {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        ListNode current = head.next;
        ListNode pre = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        head.next = null; // do not forget
        return pre;


    }

}
