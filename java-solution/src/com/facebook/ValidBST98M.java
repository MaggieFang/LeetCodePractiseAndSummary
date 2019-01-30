package com.facebook;

import com.easy.tree.TreeNode;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/9/18
 * Talk is Cheap,Show me the Code.
 **/
public class ValidBST98M {

    /**
     * KEYPOINTS:
     * <p>
     *      If it is a BST tree, inorder travel should be sorted.
     *      that is to say,the pre printed one must be less than the current one.
     *      so we can add a member to store the pre travel one.and when we travel the current one.
     *      compare it to the pre one.
     *      and the result may happen anywhere when we travel. so we can add another member result to
     *      show if it is a BST. when the compare is pre >= cur.val. set the result false;
     *      Another question we consider is the pre init value. maybe we think Integer.MIN_VALUE.
     *      but maybe there are Integer.MIN_VALUE in the tree node. but if it is a BST tree.
     *      the node with Integer.MIN_VALUE must be the first node in inorder. if we can mark the travel whether is the firstTime.
     *      if yes. then if pre >= cur.val we assume it is valid.
     *
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

    int p = Integer.MIN_VALUE;
    boolean result = true;
    boolean firstIn = true;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        inorder(root);
        return result;
    }

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (!firstIn && p >= root.val) {
            result = false;
        } else {
            p = root.val;
        }
        if (firstIn) {
            firstIn = false;
        }
        inorder(root.right);
    }
}
