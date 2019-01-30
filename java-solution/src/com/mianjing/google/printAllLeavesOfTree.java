package com.mianjing.google;

import com.easy.tree.TreeNode;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/9/19
 * Talk is Cheap,Show me the Code.
 **/
public class printAllLeavesOfTree {
    /**
     * KEYPOINTS:
     * check if root == null, yes, return
     * check if root.left == null && root.right == null  yes,print root.val
     * if root.left != null, call recursively,
     * if root.right != null, call recursively.
     * </p>
     * TIME COMPLEXITY:
     * <p>
     * SPACE COMPLEXITY:
     * <p>
     **/
    public void printLeaves(TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) System.out.println(root.val);
        if (root.left != null) printLeaves(root.left);
        if (root.right != null) printLeaves(root.right);
    }
}
