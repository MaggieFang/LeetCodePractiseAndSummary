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
     * 求BST中跟target最近的数字。我们先设置一个min = root.val，然后用iterative的办法尝试更新min， 然后比较target与root的大小，进行二分查找。
     * </p>
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
