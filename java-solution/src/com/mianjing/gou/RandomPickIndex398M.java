package com.mianjing.gou;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/10/19
 * Talk is Cheap,Show me the Code.
 **/
public class RandomPickIndex398M {
    class Solution {
        HashMap<Integer, List<Integer>> map;
        Random random;

        public Solution(int[] nums) {
            this.map = new HashMap<>();
            this.random = new Random();
            for (int i = 0; i < nums.length; i++) {
                List<Integer> list = map.getOrDefault(nums[i], new ArrayList<Integer>());
                list.add(i);
                map.put(nums[i], list);
            }
        }

        public int pick(int target) {
            if (random == null) {
                random = new Random();
            }

            if (map == null || map.get(target) == null) {
                return -1;
            }
            List<Integer> l = map.get(target);

            int i = random.nextInt(l.size());
            return l.get(i);

        }
    }


    class Solution2 {

        Random random;
        int[] nums;

        public Solution2(int[] nums) {
            this.nums = nums;
            this.random = new Random();

        }

        /**
         * Actually, that is a probability problem. If there are k target values in the array.
         * For the 1st one, the probability of (ans == i) is 1.0; for the 2nd one, the probability of
         * changing to (res == i) is 1/2, then the value keeps the previous idx is 1/2; .....
         * for the kth one, the probability of changing to the new idx is 1/k, for the each of others,
         * the prob of not changing the value is 1/(k-1) * (k-1)/k = 1/k.
         **/
        public int pick(int target) {
            int ans = -1;
            int total = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    int t = random.nextInt(++total);
                    ans = (t == 0) ? i : ans;
                }

            }
            return ans;
        }
    }

}
