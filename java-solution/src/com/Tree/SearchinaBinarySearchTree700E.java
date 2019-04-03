package com.Tree;

import com.easy.tree.TreeNode;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-04-02
 * Talk is cheap,show me the Code.
 **/
public class SearchinaBinarySearchTree700E {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * really a easy one. make a while (root != null) to check the val of root == val or not. yes return it. no then check which size to go down
     * </p>
     * TIME COMPLEXITY: O(logN)
     * SPACE COMPLEXITY:O(1)
     * </p>
     **/
    public TreeNode searchBST(TreeNode root, int val) {
        // TreeNode ans = null;
        while (root != null) {
            if (root.val == val) {
                return root;
            }
            root = val > root.val ? root.right : root.left;
        }
        return null;

    }
}
