package com.easy.linkedlist;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 9/20/18
 * Talk is Cheap,Show me the Code.
 **/
public class DeleteNode237 {
    /**
     * KEYPOINTS:
     * <p>
     * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
     * notice that it says it's not a tail and we only access to the node we want to delete.
     * So,we cannot traverse from head to find the pre node of target.
     * so we need to move the next node's val into the target node and delete the next node.
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
    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
    }


}
