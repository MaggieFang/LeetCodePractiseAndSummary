package com.easy.linkedlist;

import java.util.HashSet;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 9/20/18
 * Talk is Cheap,Show me the Code.
 **/
public class IntersectionTwoLinks160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int c1 = 0;
        int c2 = 0;
        ListNode n1 = headA;
        ListNode n2 = headB;
        while(n1 != null){
            c1++;
            n1 = n1.next;
        }

        while(n2 != null){
            c2++;
            n2 = n2.next;
        }

        n1 = headA;
        n2 = headB;
        if(c1 > c2){
            int c  = c1 - c2;
            while(c > 0){
                n1 = n1.next;
                c--;
            }
        }else if (c1 < c2){
            int c = c2 - c1;
            while(c > 0){
                n2 = n2.next;
                c--;
            }
        }
        while(n1 != null && n1!= n2){
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }
    /**
     * KEYPOINTS:
     * <p>
     *     Use two pointer, A,B
     *     when A get to the end, then A point To HeadB;
     *     when B get to the end, then B point to HeadA;
     *     that is to say, let A to traverse A+B,let B traverse B+A,
     *     they must get to the end(null) at the same time if they had no intersection;
     *     Alike,They must get to the intersection element if they had intersection.
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

    public ListNode getIntersectionNodeTwoPointer3(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }

        ListNode pA = headA;
        ListNode pB = headB;
        while(true){
            if(pA == null && pB == null){
                return null;
            }
            if(pA == pB){
                return pA;
            }
            pA = pA != null ? pA.next :headB;
            pB = pB != null ? pB.next : headA;
        }
    }

    /**
     * KEYPOINTS:
     * <p>
     *  Use an set to put one link.
     *  traverse the second one to judge if the element is in the set
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY: O(n)
     * <p>
     * SPACE COMPLEXITY:O(n)
     * <p>
    **/
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode nodeA = headA;
        while(nodeA != null){
            set.add(nodeA);
            nodeA = nodeA.next;
        }

        ListNode nodeB = headB;
        while(nodeB != null){
            if(set.contains(nodeB)){
                return nodeB;
            }
            nodeB = nodeB.next;
        }
        return null;

    }

}
