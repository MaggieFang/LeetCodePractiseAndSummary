package com.linkedin;

import com.easy.tree.TreeNode;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/29/18
 * Talk is Cheap,Show me the Code.
 **/
public class LowestCommonParentOfBST235E {
    //二刷，iterative 解法
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        int v1 = p.val;
        int v2 = q.val;
        TreeNode node = root;
        while(node != null){
            int v = node.val;
            if(v > v1 && v > v2){
                node = node.left;
            }else if( v < v1 && v < v2){
                node = node.right;
            }else{
                return node;
            }
        }
        return null;
    }

    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * according to the binary search tree (BST) character.  left < root < right
     * so if both of the p and p are less than root, it means they both on the left child, so recur to the left;
     * if both p and p larger than root, it means they both on right child, so recur to the right;
     * if root value is between them, it mean p and q one on left one on right, so root is the answer, just return.
     *
     * </p>
     * TIME COMPLEXITY: O(N) for the worst case
     * SPACE COMPLEXITY: O(N) for recur
     * </p>
     **/
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}
