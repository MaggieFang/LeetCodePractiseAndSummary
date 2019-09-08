package com.linkedin;

import com.basic.NestedInteger;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-09-07
 **/
public class FlattenNestedListIterator341M {
    /**
     * Clarification:
     * </p>
     * Keypoints:
     * we deal with the nested list in NestedWeightSum339M. and this one is a Iterator, we need a stack to help.
     * but considering the next() will return element from left to right. so if we push the element from end to start,
     * when pop up, the left element will come first, it is what we want.
     * so we can push the Initial list NestedInteger element into the stack. for hasNext(), if the top is Integer. it is the return for next().
     * if the top is a List, we repeat the push thing, to push each element into to stack from right to left.
     * the false case is the stack is empty
     * </p>
     * TIME COMPLEXITY: O(n)
     * SPACE COMPLEXITY: O(n)
     * </p>
     **/
    public class NestedIterator implements Iterator<Integer> {
        Stack<NestedInteger> stack;
        Integer cur = null;

        public NestedIterator(List<NestedInteger> nl) {
            stack = new Stack<>();
            for (int i = nl.size() - 1; i >= 0; i--) { // push element from right to left into stack
                stack.push(nl.get(i));
            }
        }

        @Override
        public Integer next() {
            return cur;
        }

        @Override
        public boolean hasNext() {
            if (stack.isEmpty()) { // no element.
                cur = null;
                return false;
            }
            NestedInteger ni = stack.pop();
            if (ni.isInteger()) { // the top element is integer.
                cur = ni.getInteger();
                return true;
            } else {
                List<NestedInteger> list = ni.getList();
                for (int i = list.size() - 1; i >= 0; i--) { // if the top element is List, push each element fro right to left into stack
                    stack.push(list.get(i));
                }
                return hasNext();
            }
        }
    }

}
