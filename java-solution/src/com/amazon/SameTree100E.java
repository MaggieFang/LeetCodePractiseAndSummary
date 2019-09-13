package com.amazon;

import com.easy.tree.TreeNode;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-09-12
 **/
public class SameTree100E {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * it provide the idea for LC101
     * </p>
     * TIME COMPLEXITY:
     * SPACE COMPLEXITY:
     * </p>
     **/
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
