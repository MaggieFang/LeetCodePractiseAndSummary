package com.easy.linkedlist;

import java.util.HashSet;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 9/20/18
 * Talk is Cheap,Show me the Code.
 **/
public class LinkedCycle141 {
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
    /**
     * KEYPOINTS:
     * <p>
     * two pointers. slow pointer and a fast pointer.
     * The slow pointer moves one step at a time while the fast pointer moves two steps at a time.
     * If there is no cycle in the list, the fast pointer will eventually reach the end and we can return false
     * Now consider a cyclic list.the slow and fast pointers are two runners racing around a circle track.
     * The fast runner will eventually meet the slow runner.
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY:O(n)
     * <p>
     * SPACE COMPLEXITY:O(1)
     * <p>
     **/
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    /**
     * KEYPOINTS:
     * <p>
     * use hashset to store the traversing elements. judge it before add it.
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

    public boolean hasCycleWithHashSet(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode node = head;
        while (node != null) {
            if (set.contains(node)) {
                return true;
            }
            set.add(node);
            node = node.next;
        }
        return false;

    }
}
