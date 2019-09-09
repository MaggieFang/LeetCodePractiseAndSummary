package com.linkedin;

import java.util.*;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-08-22
 **/
public class MaxStack716E {
    /**
     * Clarification:
     * second time
     * </p>
     * Keypoints:
     * we can use two stack, one is a general one to serve for peek,pop, s1. another one is to keep the max,s2
     * in push(x), we push it into s1, and if x >= s2.peek(),we push it into s2, too.
     * in pop(), we pop from s1, and if it == s2.peek(), we pop s2,too,
     * in peekmax, return s2.peek()
     * int popMax, we pop s2, and we need to delete it from s1, so we need an tmp stack to store the tmp element pop from s1.
     * when we pop the popped element in s1, then we push the tmp elements into s1 again, but here, we need to call push(x) not just s1.push(x)
     * since we have pop the maximun from s2, there may be some element to be the new max.
     * e.g push(5), push(3) and popMax. there is a [3] in tmp, when we push it back to s1. it also need to be in s2.
     * </p>
     * TIME COMPLEXITY: O(n)
     * SPACE COMPLEXITY:O(n)
     * </p>
     **/
    class MaxStack {
        private Stack<Integer> maxStack;
        private Stack<Integer> stack;

        /**
         * initialize your data structure here.
         */
        public MaxStack() {
            this.maxStack = new Stack<>();
            this.stack = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            if (maxStack.isEmpty() || x >= maxStack.peek()) {
                maxStack.push(x);
            }

        }

        public int pop() {
            int cur = stack.pop();
            if (!maxStack.isEmpty() && cur == maxStack.peek()) {
                maxStack.pop();
            }
            return cur;
        }

        public int top() {
            return stack.peek();

        }

        public int peekMax() {
            return maxStack.peek();
        }

        public int popMax() {
            int max = maxStack.pop();
            List<Integer> tmp = new ArrayList<>();
            int top;
            while (!stack.isEmpty() && (top = stack.pop()) != max) {
                tmp.add(top);
            }
            for (int i = tmp.size() - 1; i >= 0; i--) {
                push(tmp.get(i));
            }

            return max;
        }

    }


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
    static class MaxStack2 {
        private TreeMap<Integer, List<Node>> treeMap;// treeMap not allow duplicate key. so need a list to contain the values with same key.
        private Node head;
        private Node cur;

        /**
         * initialize your data structure here.
         */
        public MaxStack2() {
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
        MaxStack2 stack = new MaxStack2();
        stack.push(5);
        stack.push(1);
        stack.push(6);
        System.out.println(stack.peekMax());
        System.out.println(stack.popMax());
        System.out.println(stack.popMax());
        System.out.println(stack.top());
    }
}
