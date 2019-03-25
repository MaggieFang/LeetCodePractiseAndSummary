package com.fb;

import com.easy.linkedlist.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/11/18
 * Talk is Cheap,Show me the Code.
 **/
public class MergeKSortedList23H {
    /**
     * KEYPOINTS:
     * <p>
     * 1->4->5
     * <p>
     * 1->3->8
     * <p>
     * 2->6
     * how we do? we will pointer to the head of each. and get its minimum. it will be the head of result.
     * and after we choose one.we move its pointer to next. and compare the n numbers again to pick the minimum
     * keep doing so util each point to the last element.
     * <p>
     * so Min_Heap can help us to do that.
     * <p>
     * we first and the list[i] to the heap.
     * <p>
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY:O(NlogK), every time to put in a queue ,we need logK to sort the min_heap.and we do N times
     * <p>
     * SPACE COMPLEXITY: O(k)
     * <p>
     **/
    public ListNode mergeKLists(ListNode[] list) {
        if (list == null || list.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(list.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null) {
                queue.add(list[i]);
            }
        }

        ListNode head = new ListNode(0); // avoid null judgement in the while
        ListNode cur = head;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            for (int i = 0; i < list.length; i++) {
                if (node == list[i]) {
                    list[i] = list[i].next;
                    if (list[i] != null) {
                        queue.add(list[i]);
                    }
                }
            }
            cur.next = node;
            cur = cur.next;

        }
        return head.next;
    }
}
