package com.bb;

import java.util.HashMap;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-09-21
 **/
public class CopyListwithRandomPointer138M {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * need a map to store whether a node has been created.
     * and define a getNode to generate a node using val, and put it in map meanwhile.
     * 
     *
     * </p>
     * TIME COMPLEXITY:
     * SPACE COMPLEXITY:
     * </p>
     **/
    public Node copyRandomList(Node head) {
        Node h = new Node();
        HashMap<Integer, Node> map = new HashMap<>();
        Node node = head;
        Node cur = h;
        while (node != null) {
            Node n = getNode(node, map);
            n.random = getNode(node.random, map);
            cur.next = n;
            node = node.next;
            cur = cur.next;
        }
        return h.next;

    }

    private Node getNode(Node n, HashMap<Integer, Node> map) {
        if (n == null) return null;
        int v = n.val;
        if (map.containsKey(v)) {
            return map.get(v);
        }
        Node node = new Node(v, null, null);
        map.put(v, node);
        return node;
    }

    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    ;
}
