package com.easy.stack;

import java.util.ArrayList;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 9/23/18
 * Talk is Cheap,Show me the Code.
 **/
public class MinStackLinkedList155 {
    private Node head;

    public MinStackLinkedList155() {
    }

    public void push(int x) {
        if(head == null){
            head = new Node(x,x);
        }else {
            head = new Node(x,head,Math.min(head.min,x));
        }

    }

    public void pop() {
        head = head.next;

    }

    public int top() {
        if(head == null){
            return Integer.MIN_VALUE;
        }
        return head.val;
    }

    public int getMin() {
        if(head == null){
            return Integer.MIN_VALUE;
        }
        return head.min;
    }

    private class Node {
        private int val;
        private Node next;
        private int min;

        public Node(int val, int min) {
            this.val = val;
            this.min = min;
        }

        public Node(int val, Node next, int min) {
            this.val = val;
            this.next = next;
            this.min = min;
        }
    }
}
