package com.google;

import com.easy.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-08-30
 **/
public class HouseRobberIII337M {

    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * the problem exhibits the feature of "optimal substructure": if we want to rob maximum amount of money from current binary tree
     * we surely hope that we can do the same to its left and right subtrees.so it seems recur is for it. But we consider there are duplicate subproblem
     * so we can remember the sub result. so use a map to store the sub result.
     * how to compute rob(root): two cases: 1) root not rob, then result is rob(root.left)+ rob(root.right)
     * (2) root robbed. so root.left and root.right should not be robbed. then the result is
     * root.val+ rob(root.left.left)+ rob(root.left.right)+ rob(root.rigth.left)+rob(root.right.right), of course,need to check root.left/right null or not/
     * <p>
     * <p>
     * futher improvement, we can store the result of the node rob or not in a res int[2],  res[0] means the node not rob. and res[1] means the node are robbed.
     * so res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]); and res[1] = left[0] + right[0] + node.val;
     * </p>
     * TIME COMPLEXITY: O(n)
     * SPACE COMPLEXITY: O(n) or O(c) for improvement
     * </p>
     **/
    public int rob(TreeNode root) {
        return rob(root, new HashMap<>());
    }

    private int rob(TreeNode node, Map<TreeNode, Integer> memo) {
        if (node == null) return 0;
        if (memo.containsKey(node)) return memo.get(node);
        int left = rob(node.left, memo);
        int right = rob(node.right, memo);
        int includeNodeSum = 0;
        if (node.left != null) {
            includeNodeSum = rob(node.left.left, memo) + rob(node.left.right, memo);
        }
        if (node.right != null) {
            includeNodeSum += rob(node.right.left, memo) + rob(node.right.right, memo);
        }
        int res = Math.max(includeNodeSum + node.val, left + right);
        memo.put(node, res);
        return res;

    }

    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * improvement to use int[2] which r[0] store the result for node not robbed and r[1] means node robbed.
     * </p>
     * TIME COMPLEXITY:
     * SPACE COMPLEXITY:
     * </p>
     **/
    public int rob2(TreeNode root) {
        int[] res = robWithInfo(root);
        return Math.max(res[0], res[1]);
    }

    private int[] robWithInfo(TreeNode node) {
        if (node == null) return new int[]{0, 0};
        int[] left = robWithInfo(node.left);
        int[] right = robWithInfo(node.right);
        int[] res = new int[2];
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = left[0] + right[0] + node.val;
        return res;
    }

}
