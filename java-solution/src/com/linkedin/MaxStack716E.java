package com.linkedin;

import java.util.*;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-08-22
 **/
public class MaxStack716E {
    /**
     * Clarification:
     * second time; using two stack
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
     * when push(x), append to to double link list. and add to the map
     * when pop(): remove from map(remove the entry if list is empty after remove). and then make the cur pointer in link list point to pre
     * when top() just return cur.val
     * when peek() return map.lastKey
     * when popMax(); retrive the map.lastEntry(), remove from map(remove the entry if list is empty after remove).
     *  and if the remove node is cur, update the cur to the pre. if not, update the pre and next of the deleted node.
     * </p>
     * TIME COMPLEXITY:O(logN)
     * SPACE COMPLEXITY: O(N)
     * </p>
     **/
    static class MaxStack2 {
        private TreeMap<Integer,List<Node>> map; // treeMap don't allow duplicate key, need a list to store the duplicate element
        Node cur;

        /**
         * initialize your data structure here.
         */
        public MaxStack2() {
            this.map = new TreeMap<>();
            cur = new Node(Integer.MIN_VALUE);
        }

        public void push(int x) {
            Node node = new Node(x);
            cur.next = node;
            node.pre = cur;
            cur = node;
            List<Node> list = map.getOrDefault(x,new ArrayList<>());
            list.add(node);
            map.put(x,list);

        }

        public int pop() {

            List<Node> list = map.get(cur.val);
            list.remove(list.size() -1);
            if(list.size() == 0){ // important. when the list is empty,remove the entry
                map.remove(cur.val);
            }
            int r = cur.val;
            cur = cur.pre;
            cur.next = null;
            return r;

        }

        public int top() {
            return cur.val;

        }

        public int peekMax() {
            return map.lastKey();
        }

        public int popMax() {
            Map.Entry<Integer,List<Node>> entry = map.lastEntry();
            List<Node> list = entry.getValue();
            Node remove = list.remove(list.size() - 1);
            if(list.size()== 0){
                map.remove(entry.getKey());
            }
            if(remove == cur){ // if the remove node is cur one. update the cur to pre
                cur = cur.pre;
                cur.next = null;
            }else{ // update the delete node pre and next pointer
                remove.pre.next = remove.next;
                remove.next.pre = remove.pre;
                remove.pre = null;
                remove.next = null;
            }
            return remove.val;

        }

        static class Node {
            int val;
            Node pre;
            Node next;

            public Node(int v) {
                this.val = v;
            }
        }

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
