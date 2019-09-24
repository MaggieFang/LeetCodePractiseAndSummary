package com.bb;

import javax.xml.soap.Node;
import java.util.Stack;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-09-24
 **/
public class FlattenaMultilevelDoublyLinkedList430M {
    public Node flatten(Node head) {
        if (head == null) return null;
        Stack<Node> stack = new Stack<>();
        Node node = head;
        while (node != null || !stack.isEmpty()) {
            if (node.child != null) {
                if (node.next != null) stack.push(node.next);
                node.next = node.child;
                node.next.prev = node;
                node.child = null;
            } else {
                if (node.next == null && !stack.isEmpty()) {
                    node.next = stack.pop();
                    node.next.prev = node;
                }
            }
            node = node.next;
        }
        return head;

    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {
        }

        public Node(int _val, Node _prev, Node _next, Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }

    ;
}
