package com.amazon;


import java.util.List;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-09-12
 **/
public class MaximumDepthofNarryTree559E {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * an extension for MaxDepthOfBT104
     * </p>
     * TIME COMPLEXITY: we visit each node exactly once, O(N)
     * SPACE COMPLEXITY: in the worst case, unblanced tree, the recursion call would occur N times,so O(N)
     *                  but best for blanced tree O(LogN)
     * </p>
     **/
    public int maxDepth(Node root) {
        if (root == null) return 0;
        if (root.children == null || root.children.size() == 0) return 1;
        int n = root.children.size();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, maxDepth(root.children.get(i)));
        }
        return max + 1;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;
}
