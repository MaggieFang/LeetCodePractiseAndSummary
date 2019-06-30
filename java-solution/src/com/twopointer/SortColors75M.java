package com.twopointer;

import java.util.Map;
import java.util.TreeMap;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-06-29
 **/
public class SortColors75M {

    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * use two pointer, the left one means need a red, the right one mean a blue, and use a i to travel from 0,
     * when it is 0, exchange with the left and left++. when it is 2, exchange with the right left and right--
     * </p>
     * TIME COMPLEXITY: O(n)
     * SPACE COMPLEXITY:O(1)
     * </p>
     **/

    public void sortColors2(int[] nums) {
        int red = 0, blue = nums.length - 1;

        for (int i = 0; i <= blue; i++) {
            if (nums[i] == 0) {
                int tmp = nums[red];
                nums[red++] = nums[i];
                nums[i] = tmp;
            } else if (nums[i] == 2) {
                int tmp = nums[blue];
                nums[blue--] = nums[i];
                // take care of here, i need to --, e.g 1,2,0. since before i, there is no 2, so when you change with the left one,
                // i can move on, but when you change with 2, the current i may be 0, we should stay here and don't move forward.
                nums[i--] = tmp;
            }
        }
    }

    // two pass, use a map to count the elements. then reset the nums.
    public void sortColors(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int n : nums) {
            int cnt = map.getOrDefault(n, 0);
            map.put(n, cnt + 1);
        }
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            for (int j = 0; j < entry.getValue(); j++) {
                nums[i++] = entry.getKey();
            }
        }
    }

}
