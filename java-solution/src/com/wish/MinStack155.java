package com.wish;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 9/23/18
 * Talk is Cheap,Show me the Code.
 **/
public class MinStack155 {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * can use same method with MaxStack716E but it is easier since needn't implement popMin
     * use two stack, one is a general one to serve for peek,pop, s1. another one is to keep the min,s2
     * in push(x), we push it into s1, and if  s2.peek() >= x,we push it into s2, too.
     * in pop(), we pop from s1, and if it == s2.peek(), we pop s2,too,
     * in peekmax, return s2.peek()
     * </p>
     * TIME COMPLEXITY:
     * SPACE COMPLEXITY:
     * </p>
     **/

    class MinStack {
        private Stack<Integer> minStack;
        private Stack<Integer> stack;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            this.minStack = new Stack<>();
            this.stack = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            if (minStack.isEmpty() || minStack.peek() >= x) {
                minStack.push(x);
            }
        }

        public void pop() {
            int e = stack.pop();
            if (minStack.peek() == e) {
                minStack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

    private int min = Integer.MAX_VALUE;
    private ArrayList<Integer> elements;

    public MinStack155() {
        elements = new ArrayList<>();

    }

    public void push(int x) {
        elements.add(x);
        if (x < min) {
            min = x;
        }

    }

    public void pop() {
        if (elements == null || elements.size() == 0) {
            return;
        }
        int e = elements.get(elements.size() - 1);
        elements.remove(elements.get(elements.size() - 1));
        if (e == min) {
            min = Integer.MAX_VALUE;
            for (int i : elements) {
                if (i < min) {
                    min = i;
                }
            }
        }


    }

    public int top() {
        if (elements == null || elements.size() == 0) {
            return Integer.MIN_VALUE;
        }
        return elements.get(elements.size() - 1);

    }

    public int getMin() {
        return min;
    }
}
