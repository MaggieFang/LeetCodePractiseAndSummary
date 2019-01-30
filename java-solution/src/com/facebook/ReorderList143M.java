package com.facebook;

import com.easy.linkedlist.ListNode;

import java.util.List;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/8/18
 * Talk is Cheap,Show me the Code.
 **/
public class ReorderList143M {
    /**
     * KEYPOINTS:
     * <p>
     *     so this is to put the latter half reverse. and then insert in into the pre half part.
     *     so firstly we can find the mid to cut the link into two links.
     *     and then reverse the latter part.
     *     and then traverse the two link to insert the latter half part into the first part.
     * <p>
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY:
     * <p>
     * SPACE COMPLEXITY:
     * <p>
     **/
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        int num = 0;
        ListNode node = head;
        while (node != null) {
            num++;
            node = node.next;
        }

        int mid = (num + 1) / 2;

        node = head;
        num = 0;
        ListNode pre = head;
        while (num < mid) {
            pre = node;
            node = node.next;
            num++;
        }
        pre.next = null; //别忘了用这个把前边半截砍断，不然再后面循环到这里不能停止了
        ListNode halfHead = reverse(node);
        node = head;
        while (halfHead != null) {
            ListNode next = node.next;
            ListNode halfNext = halfHead.next;
            node.next = halfHead;
            halfHead.next = next;
            halfHead = halfNext;
            node = next;
        }
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head.next = null;
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        ReorderList143M test = new ReorderList143M();
        test.reorderList(head);

    }
}
