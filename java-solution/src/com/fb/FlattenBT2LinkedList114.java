package com.fb;

import com.easy.tree.TreeNode;

import java.util.Stack;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/15/18
 * Talk is Cheap,Show me the Code.
 **/
public class FlattenBT2LinkedList114 {
    /**
     * KEYPOINTS:
     * <p>
     *       1
            / \
           2   5
         / \   \
        3   4   6
result:

     1
     \
     2
     \
     3
     \
     4
     \
     5
     \
     6
       so we need to print the root,and go left to print left root and go left till the end and backtrace to the right.

     so we can use a stack. and pop the node, let its left = null, and the pre existing right point to this node.
     so before we set the left = null. we need to push it right and left child into the stack
     }
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *     push(root);
     *     while(notEmpty){
     *      pop node;
     *      if(node.right != null){
     *          push(node.right)
     *       }
     *      if(node.left != null){
     *           push(left);
     *      }
     * </code>
     * </pre>
     * TIME COMPLEXITY:
     * <p>
     * SPACE COMPLEXITY:
     * <p>
    **/
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        TreeNode cur = null;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }

            node.left = null;

            if (cur == null) {
                cur = node;
            } else {
                cur.right = node;
                cur = node;
            }
        }

    }
}
