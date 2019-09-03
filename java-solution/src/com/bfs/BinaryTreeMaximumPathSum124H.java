package com.bfs;

import com.easy.tree.TreeNode;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-02-10
 * Talk is cheap,show me the Code.
 **/
public class BinaryTreeMaximumPathSum124H {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * For each node there can be four ways that the max path goes through the node:
     * 1. Node only
     * 2. Max path through Left Child + Node
     * 3. Max path through Right Child + Node
     * 4. Max path through Left Child + Node + Max path through Right Child
     * The idea is to keep trace of four paths and pick up the max one in the end.
     * An important thing to note is, root of every subtree need to return maximum path sum such that at most one child of root is involved.
     * This is needed for parent function call.Otherwise it will not build a path
     * </p>
     * TIME COMPLEXITY: O(n) where N is number of nodes, since we visit each node not more than 2 times
     * SPACE COMPLEXITY:O(log(N)). We have to keep a recursion stack of the size of the tree height,O(logN) for the binary tree.
     * </p>
     **/
    private int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        findMax(root);
        return ans;
    }

    public int findMax(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int cur = root.val;
        int left = findMax(root.left);
        int right = findMax(root.right);
        cur = Math.max(cur, Math.max(left, right) + root.val);
        //cur = Math.max(cur,left+right+root.val);
        // this update the final answer ans,but the result it return will be sub max for its parents. so the result we return contains at most one child.
        int max = Math.max(cur, left + right + root.val);
        ans = Math.max(max, ans);
        return cur;
    }
}
