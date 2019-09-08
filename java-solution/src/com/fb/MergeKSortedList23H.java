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
     * 1->4->5
     * 1->3->8
     * 2->6
     * how we do? we will pointer to the head of each. and get its minimum. it will be the head of result.
     * and after we choose one.we move its pointer to next. and compare the n numbers again to pick the minimum
     * keep doing so util each point to the last element.
     * so Min_Heap can help us to do that.
     * we first and the list[i] to the heap.
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY:O(NlogK), K is the size of list, N is the total nodes .
     * every time to put in a queue ,we need logK to sort the min_heap.and we do N times
     * <p>
     * SPACE COMPLEXITY: O(k) K is the size of list
     * <p>
     **/
    public ListNode mergeKLists(ListNode[] list) {
        if (list == null || list.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>((ListNode o1, ListNode o2) -> o1.val - o2.val);
        for (ListNode node : list) {
            if (node != null) {
                queue.add(node);
            }
        }
        
        ListNode head = new ListNode(0); // avoid null judgement in the while
        ListNode cur = head;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
//            for(ListNode i : list){
//                if(node == i){
//                    i = i.next; //这么做是不行的，没有把他赋值回去list[i]
//                    if(i != null){
//                        queue.add(i);
//                    }
//                }
//            }
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
