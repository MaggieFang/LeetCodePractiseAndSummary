package com.Tree;

import com.easy.tree.TreeNode;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-04-06
 * Talk is cheap,show me the Code.
 **/
public class InsertintoaBinarySearchTree701M {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * 
     * </p>
     * TIME COMPLEXITY:
     * SPACE COMPLEXITY:
     * </p>
     **/
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
        } else if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        } else {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }
}
