package com.amazon;

import com.easy.tree.TreeNode;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 11/27/18
 * Talk is Cheap,Show me the Code.
 **/
public class InorderSuccessorBST285M {
    /**
     * KEYPOINTS:
     * <p>
     * if root.val > p.val. root can be a possible answer, so we store the root node first and call it ans.
     *   However, we don't know if there is anymore node on root's left that is larger than p.val. So we move root to its left and check again.
     * if root.val <= p.val. root cannot be p's inorder successor, neither can root's left child.
     *   So we only need to consider root's right child, thus we move root to its right and check again.
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY:
     * <p>
     * SPACE COMPLEXITY:
     * <p>
     **/
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }

        TreeNode ans = null;
        while (root != null) {
            if (p.val < root.val) {
                ans = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return ans;
    }
}
