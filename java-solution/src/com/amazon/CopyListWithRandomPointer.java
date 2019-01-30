package com.amazon;

import java.util.HashMap;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/30/18
 * Talk is Cheap,Show me the Code.
 **/
public class CopyListWithRandomPointer {
    /**
     * KEYPOINTS:
     * <p>
     * if we not have the random. we will create newNode as go a loop for old.
     * So after we create the new List,we loop from begin to handle the random.
     * so we need to find the old.random 's pair of new One. so a map can help us.
     * map(old,new). so when loop the old.random. get the new node to point to from map.get(old.randon)
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY: O(n)
     * <p>
     * SPACE COMPLEXITY: O(n)
     * <p>
     **/
    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode newH = new RandomListNode(0);
        RandomListNode old = head;
        RandomListNode tmp = newH;
        while (old != null) {
            RandomListNode node = new RandomListNode(old.label);
            map.put(old, node);
            tmp.next = node;
            tmp = tmp.next;
            old = old.next;
        }
        old = head;
        tmp = newH.next;
        while (old != null) {
            RandomListNode or = old.random;
            tmp.random = map.get(or);
            old = old.next;
            tmp = tmp.next;
        }
        return newH.next;
    }

    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }

    ;
}
