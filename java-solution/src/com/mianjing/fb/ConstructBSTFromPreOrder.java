package com.mianjing.fb;

import com.easy.tree.TreeNode;

import java.util.Stack;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/16/18
 * Talk is Cheap,Show me the Code.
 **/
public class ConstructBSTFromPreOrder {
    /**
     * KEYPOINTS:
     * <p>
     * For example, if the given traversal is {10, 5, 1, 7, 40, 50},
     * Following is a stack based iterative solution that works in O(n) time.
     * 1. Create an empty stack.
     * 2. Make the first value as root. Push it to the stack.
     * 3. Keep on popping while the stack is not empty and the next value is greater than stack’s top value.
     * Make this value as the right child of the last popped node. Push the new node to the stack.
     * 4. If the next value is less than the stack’s top value, make this value as the left child of
     * the stack’s top node. Push the new node to the stack.
     * 5. Repeat steps 2 and 3 until there are items remaining in pre[].
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY:
     * <p>
     * SPACE COMPLEXITY:
     * <p>
     **/
    public TreeNode constructTree(int[] pre) {
        TreeNode root = new TreeNode(pre[0]);

        Stack<TreeNode> s = new Stack<TreeNode>();

        // Push root
        s.push(root);

        // Iterate through rest of the size-1 items of given preorder array
        for (int i = 1; i < pre.length; ++i) {
            TreeNode temp = null;

            /* Keep on popping while the next value is greater than
             stack's top value. */
            while (!s.isEmpty() && pre[i] > s.peek().val) {
                temp = s.pop();
            }

            // Make this greater value as the right child and push it to the stack
            if (temp != null) {
                temp.right = new TreeNode(pre[i]);
                s.push(temp.right);
            }

            // If the next value is less than the stack's top value, make this value
            // as the left child of the stack's top node. Push the new node to stack
            else {
                temp = s.peek();
                temp.left = new TreeNode(pre[i]);
                s.push(temp.left);
            }
        }

        return root;

    }

    /**
     * KEYPOINTS:
     * <p>
     * The first element of preorder traversal is always root. We first construct the root.
     * Then we find the index of first element which is greater than root. Let the index be ‘i’.
     * The values between root and ‘i’ will be part of left subtree,
     * and the values between ‘i+1’ and ‘n-1’ will be part of right subtree.
     * Divide given pre[] at index “i” and recur for left and right sub-trees.
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY: O(n^2)
     * <p>
     * SPACE COMPLEXITY:
     * <p>
     **/
    public TreeNode constructTree2(int[] pre) {
        TreeNode root = new TreeNode(pre[0]);
        return construct2(pre, 0, pre.length - 1);

    }

    public TreeNode construct2(int[] pre, int start, int end) {
        if (start > end) {
            return null;
        }

        TreeNode root = new TreeNode(pre[start]);

        int i = start;
        for (; i <= end; i++) {
            if (pre[i] > pre[start]) {
                break;
            }
        }
        root.left = construct2(pre, start, i - 1);
        root.right = construct2(pre, i, end);
        return root;
    }

    public static void main(String[] args) {
        int[] A = new int[]{10, 5, 1, 7, 40, 50};
        ConstructBSTFromPreOrder test = new ConstructBSTFromPreOrder();
        test.constructTree(A);
    }

}
