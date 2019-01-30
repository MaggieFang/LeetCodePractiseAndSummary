package com.mianjing.fb;

import com.easy.tree.TreeNode;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/7/18
 * Talk is Cheap,Show me the Code.
 **/
public class ConvertBST2DoubleLinkdList426M {
    TreeNode pre;

    /**
     * KEYPOINTS:
     * <p>
     *    step1: inorder tranversal by recursion to connect the original BST
     *    step2: connect the head and tail to make it circular
     *    Tips: Using dummy node to handle corner case
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY:O(n)
     * <p>
     * SPACE COMPLEXITY:O(1)
     * <p>
    **/
    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode dummy = new TreeNode(Integer.MIN_VALUE, null, null);
        pre = dummy;

        inorderHelper(root);

        pre.right = dummy.right;
        dummy.right.left = pre;
        return dummy.right;
    }

    public void inorderHelper(TreeNode cur) {
        if (cur == null) {
            return;
        }
        inorderHelper(cur.left);
        pre.right = cur;
        cur.left = pre;
        pre = cur;
        inorderHelper(cur.right);

    }
}
