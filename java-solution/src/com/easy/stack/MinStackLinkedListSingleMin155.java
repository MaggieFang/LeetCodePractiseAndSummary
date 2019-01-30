package com.easy.stack;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 9/23/18
 * Talk is Cheap,Show me the Code.
 **/
public class MinStackLinkedListSingleMin155 {
    private Node head;
    private int min = Integer.MAX_VALUE;

    public MinStackLinkedListSingleMin155() {
    }

    public void push(int x) {
        if(head == null){
            head = new Node(x);
        }else {
            head = new Node(x,head);
        }

        if(min > x){
            min = x;
        }
    }

    public void pop() {
        int val = head.val;
        head = head.next;
        if(val == min){
            Node node = head;
            min = Integer.MAX_VALUE;
            while (node != null){
                if(node.val < min){
                    min = node.val;
                }
                node = node.next;
            }
        }


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
        return min;
    }

    private class Node {
        private int val;
        private Node next;

        public Node(int val) {
            this(val,null);
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;

        }
    }
}
