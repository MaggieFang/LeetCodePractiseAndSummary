package com.google;

import java.util.Stack;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-09-02
 **/
public class LargestRectangleinHistogram84H {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * https://www.youtube.com/watch?v=KkJrGxuQtYo
     * when comes to ith, we find the max of including this element. so we need to traversal back to i -1, i-2,..., 0 to
     * check the rectangle the combine.
     * But there is a little improvement here, we only check the one when reach a temparary peak, which means when h[i+1] < h[i],
     * we stop to check what we said above. this is because if it increase sorted.the prior ones will be computed here.
     *
     * </p>
     * TIME COMPLEXITY: O(n^2)
     * SPACE COMPLEXITY: O(1)
     * </p>
     **/
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            if (i == heights.length - 1 || heights[i + 1] < heights[i]) {
                int minHeight = heights[i]; // take care.
                for (int j = i; j >= 0; j--) {
                    minHeight = Math.min(minHeight, heights[j]);
                    max = Math.max(max, minHeight * (i - j + 1));
                }
            }
        }
        return max;
    }

    public int largestRectangleArea2(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxarea = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i])
                maxarea = Math.max(maxarea, heights[stack.pop()] * (i - stack.peek() - 1));
            stack.push(i);
        }
        while (stack.peek() != -1)
            maxarea = Math.max(maxarea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        return maxarea;
    }
}
