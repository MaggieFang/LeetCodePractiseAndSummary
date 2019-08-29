package com.linkedin;

import java.util.*;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-08-22
 **/
public class MaxStack716E {

    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * using treeMap + double link list.
     *
     * </p>
     * TIME COMPLEXITY:
     * SPACE COMPLEXITY:
     * </p>
     **/
    static class MaxStack {
        private TreeMap<Integer, List<Node>> treeMap;// treeMap not allow duplicate key. so need a list to contain the values with same key.
        private Node head;
        private Node cur;

        /**
         * initialize your data structure here.
         */
        public MaxStack() {
            treeMap = new TreeMap<>();
            head = new Node(Integer.MIN_VALUE);
            cur = head;
        }

        public void push(int x) {
            Node node = new Node(x);
            cur.next = node;
            node.pre = cur;
            cur = node;
            List<Node> nodes = treeMap.getOrDefault(x, new ArrayList<>());
            nodes.add(node);
            treeMap.put(x, nodes);

        }

        public int top() {
            return cur.val;

        }

        public int peekMax() {
            return treeMap.lastKey();
        }

        public int pop() {
            Node tmp = cur.pre;
            tmp.next = cur.next;
            cur.pre = null;
            int r = cur.val;
            List<Node> nodes = treeMap.get(r);
            nodes.remove(nodes.size() - 1);
            if (nodes.size() == 0) treeMap.remove(r);
            cur = tmp;
            return r;
        }

        public int popMax() {
            Map.Entry<Integer, List<Node>> entry = treeMap.lastEntry();
            List<Node> nodes = entry.getValue();
            int r = entry.getKey();
            Node node = nodes.remove(nodes.size() - 1);
            if (nodes.size() == 0)
                treeMap.remove(r); // important. otherwise, the max key will still here though actually not value exists.
            if (node == cur) { // when the max is the current node.
                cur = node.pre;
            }
            node.pre.next = node.next;
            if (node.next != null) { //maybe the last one
                node.next.pre = node.pre;
            }
            node.next = null;
            node.pre = null;
            return r;
        }

        class Node {
            int val;
            Node pre;
            Node next;

            public Node(int v) {
                this.val = v;
            }
        }
    }

    public static void main(String[] args) {
        MaxStack stack = new MaxStack();
        stack.push(5);
        stack.push(1);
        stack.push(6);
        System.out.println(stack.peekMax());
        System.out.println(stack.popMax());
        System.out.println(stack.popMax());
        System.out.println(stack.top());
    }
}
