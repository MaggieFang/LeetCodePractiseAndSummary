package com.test;

import java.util.LinkedList;


/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/9/18
 * Talk is Cheap,Show me the Code.
 **/
public class BFSvsDFSforBinaryTree {
/**
 * 宽度的借用FIFO queue, 深度的借用FILO stack
 * All four traversals require O(n) time as they visit every node exactly once.
 * Extra Space required for Level Order Traversal is O(w) where w is maximum width of Binary Tree.
 * In level order traversal, queue one by one stores nodes of different level.
 * Extra Space required for Depth First Traversals is O(h) where h is maximum height of Binary Tree.
 * In Depth First Traversals, stack (or function call stack) stores all ancestors of a node.
 * **/


    /**
     * With help of FIFO queue:
     * time O(n)
     * space O(max width of tree)
     *
     * @param root root
     */
    public void BFSTravel(BinaryNode root) {
        if (root == null) {
            return;
        }

        LinkedList<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode node = queue.poll();
            System.out.println(node.data);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }
}
