package com.easy.stack;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 9/23/18
 * Talk is Cheap,Show me the Code.
 **/
public class MinStack155 {
    public static void main(String[] args) {
        MinStack155 stack = new MinStack155();
        stack.push(2);
        stack.push(0);
        stack.push(3);
        stack.push(2);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());

        stack.pop();
        System.out.println(stack.getMin());

        stack.pop();
        System.out.println(stack.getMin());
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
