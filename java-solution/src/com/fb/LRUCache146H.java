package com.fb;

import java.util.HashMap;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/11/18
 * Talk is Cheap,Show me the Code.
 **/
public class LRUCache146H {
    /**
     * KEYPOINTS:
     * <p>
     * To add in o(1), maybe linked list can help , two points point to  the head and tail,
     * when we add one, we can add it after that.and when it reach the max size,we just move the head next.
     * But it require that if the key had been added. not added but we had to update it.
     * so we need a Map to store that if the key had been added. if not.we can insert it in the linkedList
     * but if yes, we had to find it in the list to update it. if we use a single link. we had O(n) to find.
     * But double linked can be find to in O(1)
     * so the put:
     * 1) check if it contains in the map.
     * if not, insert into the double-linked list;put it in the map
     * if yes, to remove it and add it again to keep it newsest(we assume we add the newest to the head.)
     * 2) check if need to delete an oldest one.(the tail)
     * the get:
     * 1) check if it contains in the map.
     * if yes,return the node.value. but we need to update this node to the newest positon because it is the newest visited.
     * if no. just return -1;
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
    private final int CAPACITY;
    private LRUNode head, tail;
    private int count;
    private HashMap<Integer, LRUNode> map;


    public LRUCache146H(final int capacity) {
        CAPACITY = capacity;
        map = new HashMap<>();
        head = new LRUNode();
        tail = new LRUNode();
        head.next = tail;
        tail.pre = head;

    }

    public int get(int key) {
        LRUNode node = map.get(key);
        if (node != null) {
            update(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        LRUNode node = map.get(key);
        if (node == null) {
            node = new LRUNode(key, value);
            add(node);
            map.put(key, node);
        } else {
            update(node);
        }
        if (count > CAPACITY) {
            LRUNode toDel = tail.pre;
            remove(toDel);
            map.remove(toDel.key);
            --count;
        }

    }

    private void update(LRUNode node) {
        remove(node);
        add(node);
    }

    private void add(LRUNode node) {
        LRUNode next = head.next;
        head.next = node;
        node.pre = head;
        node.next = next;
        count++;
    }

    private void remove(LRUNode node) {
        LRUNode next = node.next;
        LRUNode pre = node.pre;
        pre.next = next;
        next.pre = pre;
        count--;
    }

    public static class LRUNode {
        int key;
        int value;
        LRUNode pre;
        LRUNode next;

        public LRUNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public LRUNode() {
            this(0, 0);
        }
    }
}
