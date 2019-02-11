package com.mianjing.gou;

import com.basicStructure.DoubleLinkedListNode;
import com.easy.linkedlist.ListNode;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-02-11
 * Talk is cheap,show me the Code.
 **/
public class DeleteNodeInDoubleLinkedList {
    public void deleteNode(DoubleLinkedListNode head, DoubleLinkedListNode del) {
        if (head == null || del == null) {
            return;
        }
        if (head == del) {
            head = del.next;
        }
        if (del.next != null) {
            del.next.prev = del.prev;
        }
        if (del.prev != null) {
            del.prev.next = del.next;
        }
    }
}
