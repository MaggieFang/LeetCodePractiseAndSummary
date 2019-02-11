package com.mianjing.gou;

import java.util.Random;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/10/19
 * Talk is Cheap,Show me the Code.
 **/
public class RandomPickwithWeight528M {
    /**
     * KEYPOINTS:
     * <p>
     * [0.3,0.2,0.5] so there are 30% to get 0 and 20% get 1 and 50% get 2
     * presum. [0.3,0,5,1.0],when random generate <= 0.3 return 0,(30%), when (0.3,0.5] return 1,
     * and (0.5,1] return 2
     * </p>
     * TIME COMPLEXITY: O(N) preprocessing and o(log(n)) for pick
     * <p>
     * SPACE COMPLEXITY:
     * <p>
     **/
    class Solution {

        int[] w;
        Random random;

        public Solution(int[] w) {
            random = new Random();
            for (int i = 1; i < w.length; i++) {
                w[i] += w[i - 1];
            }
            this.w = w;
        }

        public int pickIndex() {
            int r = random.nextInt(w[w.length - 1]);
            int low = 0;
            int high = w.length - 1;
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (w[mid] <= r) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return high;

        }
    }
}
