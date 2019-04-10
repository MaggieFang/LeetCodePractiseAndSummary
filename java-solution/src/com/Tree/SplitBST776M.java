package com.Tree;

import com.easy.tree.TreeNode;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-04-09
 * Talk is cheap,show me the Code.
 **/
public class SplitBST776M {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * the root will be in the first part or the second part. when?
     * 1. when the root.val <= V, the root will be in the first part,
     *   so it will be the root for the first part. so we need to decide the new right child for it. we need to recur split the right child.
     *   and its left result will be the new right child. and the right result will be the new second root.
     *
     * 2. when the root.val > val, the root will be in the second part root. and we need to decide the new left child for it.
     * we nedd to recur split the left child and its right result will be the new left child and the left result will be the new first root.
     *
     * </p>
     * TIME COMPLEXITY: O (n)each node is checked once.
     * SPACE COMPLEXITY: O (n)
     * </p>
     **/
    public TreeNode[] splitBST(TreeNode root, int V) {
        if (root == null) {
            return new TreeNode[]{null, null};
        }

        if (root.val <= V) {
            TreeNode r1 = root;
            //r1.right = splitBST(root.right,V)[0];
            TreeNode[] tmp = splitBST(root.right, V);
            r1.right = tmp[0];
            TreeNode r2 = tmp[1];
            return new TreeNode[]{r1, r2};
        } else {
            TreeNode r2 = root;
            TreeNode[] tmp = splitBST(root.left, V);
            r2.left = tmp[1];
            TreeNode r1 = tmp[0];
            return new TreeNode[]{r1, r2};
        }
    }
}
