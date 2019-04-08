package com.Tree;

import com.easy.tree.TreeNode;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-04-06
 * Talk is cheap,show me the Code.
 **/
public class DeleteNodeinBST450M {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * Recursively find the node that has the same value as the key, while setting the left/right nodes equal to the returned subtree
     * Once the node is found, have to handle the below 4 cases
     * node doesn't have left or right - return null
     * node only has left subtree- return the left subtree
     * node only has right subtree- return the right subtree
     * node has both left and right - find the minimum value in the right subtree, set that value to the currently found node,
     * then recursively delete the minimum value in the right subtree
     * </p>
     * TIME COMPLEXITY: O(h)
     * SPACE COMPLEXITY:
     * </p>
     **/
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }

            TreeNode min = findMin(root.right);
            root.val = min.val;
            root.right = deleteNode(root.right, min.val);
        }
        return root;

    }

    public TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
