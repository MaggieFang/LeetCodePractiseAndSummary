package com.linkedin;

import com.easy.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-09-12
 **/
public class FindLeavesofBinaryTree366M {
    /**
     * Clarification:
     * <p>
     * 1
     * / \
     * 2   3
     * / \
     * 4   5
     * <p>
     * Output: [[4,5,3],[2],[1]]
     * </p>
     * Keypoints:
     * refer to MaxDepthOfBT104, this can be down to find  the depth for each node. the depth is the result index this node should be put
     * given above example, for 1, the depth 3, it should be in res[2], for 2, the depth is 1, and for 3 is 0,so it should be in res[0],...
     * so we can refer to the MaxDepthOfBT104, to find the depth, durning the recur, we store the result for each depth.
     *
     * </p>
     * * TIME COMPLEXITY: we visit each node exactly once, O(N)
     * * SPACE COMPLEXITY: in the worst case, unblanced tree, the recursion call would occur N times,so O(N)
     * *                  but best for blanced tree O(LogN)
     * </p>
     **/
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        maxDepth(root, list);
        return list;

    }

    private int maxDepth(TreeNode root, List<List<Integer>> res) {
        if (root == null) return -1;
        int depth = 1 + Math.max(maxDepth(root.left, res), maxDepth(root.right, res));
        if (depth >= res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(depth).add(root.val);
        return depth;
    }
}
