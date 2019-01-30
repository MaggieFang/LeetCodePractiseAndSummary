package com.mianjing.fb;

import com.easy.tree.TreeNode;

import java.util.Stack;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 9/28/18
 * Talk is Cheap,Show me the Code.
 **/
public class SymmetricTree101 {
    /**
     * KEYPOINTS:
     * <p>
     * trees are a mirror reflection of each other if:
     * Their two roots have the same value.
     * The right subtree of each tree is a mirror reflection of the left subtree of the other tree
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY: O(n)
     * <p>
     * SPACE COMPLEXITY:stack
     * <p>
     **/

    public boolean isSymmetricRecur(TreeNode root) {
        return isMirror(root, root);

    }

    public boolean isMirror(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) {
            return true;
        }
        if (r1 == null || r2 == null) {
            return false;
        }
        return (r1.val == r2.val) && isMirror(r1.left, r2.right) && isMirror(r1.right, r2.left);
    }


    public boolean isSymmetricNonRecurrence(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.isEmpty()) {
            TreeNode l = stack.pop();
            TreeNode r = stack.pop();
            if (l == null && r == null) {
                continue;
            }
            if (l == null || r == null) {
                return false;
            }

            if (l.val != r.val) {
                return false;
            }

            stack.push(l.left);
            stack.push(r.right);
            stack.push(l.right);
            stack.push(r.left);

        }
        return true;
    }


}
