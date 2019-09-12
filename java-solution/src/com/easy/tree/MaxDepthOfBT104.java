package com.easy.tree;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 9/28/18
 * Talk is Cheap,Show me the Code.
 **/
public class MaxDepthOfBT104 {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     *
     * </p>
     * TIME COMPLEXITY: we visit each node exactly once, O(N)
     * SPACE COMPLEXITY: in the worst case, unblanced tree, the recursion call would occur N times,so O(N)
     *                  but best for blanced tree O(LogN)
     * </p>
     **/
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
