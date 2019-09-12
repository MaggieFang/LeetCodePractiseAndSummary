package com.Tree;

import com.easy.tree.TreeNode;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-04-02
 * Talk is cheap,show me the Code.
 **/
public class ClosestBinarySearchTreeValue270E {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * since BST have the feature of left.val < root.val < right.val.we can initial the min is root. and then
     * compare the target with root.val, if target < root.val, maybe a much min one exists in the left;
     * otherwise, target > root.val. maybe a much min one is in the right.
     * * </p>
     * TIME COMPLEXITY: O(logN)
     * SPACE COMPLEXITY:O(1)
     * </p>
     **/
    public int closestValue(TreeNode root, double target) {
        int min = root.val;
        while (root != null) {
            min = Math.abs(target - root.val) < Math.abs(target - min) ? root.val : min;
            root = target < root.val ? root.left : root.right;
        }
        return min;
    }
}
