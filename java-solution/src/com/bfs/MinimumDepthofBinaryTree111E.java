package com.bfs;

import com.easy.tree.TreeNode;

import java.util.Stack;

import javafx.util.Pair;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/4/19
 * Talk is Cheap,Show me the Code.
 **/
public class MinimumDepthofBinaryTree111E {
    // O(n), visited each node once. Space O(n),
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int min_depth = Integer.MAX_VALUE;
        if (root.left != null) {
            min_depth = Math.min(minDepth(root.left), min_depth);
        }

        if (root.right != null) {
            min_depth = Math.min(minDepth(root.right), min_depth);
        }
        return min_depth + 1;

    }

    public int minDepthDFS(TreeNode root) {

        if (root == null) {
            return 0;
        }
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair(root, 1));
        int min_depth = Integer.MAX_VALUE;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> current = stack.pop();
            root = current.getKey();
            int current_depth = current.getValue();
            if ((root.left == null) && (root.right == null)) {
                min_depth = Math.min(min_depth, current_depth);
            }
            if (root.left != null) {
                stack.push(new Pair(root.left, current_depth + 1));
            }
            if (root.right != null) {
                stack.push(new Pair(root.right, current_depth + 1));
            }
        }
        return min_depth;
    }
}
