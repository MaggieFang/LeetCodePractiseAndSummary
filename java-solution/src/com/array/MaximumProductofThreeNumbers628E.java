package com.array;

import java.util.Arrays;

public class MaximumProductofThreeNumbers628E {


    // improve from the sort method, we just need the find the 5 numbers we want.[min1,min2, max3,max2,max1]
    public int maximumProduct(int[] nums) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        // gets [min1,min2, max3,max2,max1]
        for (int n : nums) {
            if (n < min1) {
                min2 = min1;
                min1 = n;
            } else if (n < min2) { // n lies [min1,min2]
                min2 = n;
            }

            if (n > max1) {  // n > max1,max2,max3
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n > max2) { // n lies between max1 and max2,
                max3 = max2;
                max2 = n;
            } else if (n > max3) {  // n lies between max2 and max3
                max3 = n;
            }
        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }

    /**
     * sort();
     * (+): get the last 3
     * (+&-): the last3 or the first 2 and last 1
     * (-): the last 3.
     **/
    public int maximumProduct1(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[n - 1] * nums[n - 2] * nums[n - 3], nums[0] * nums[1] * nums[n - 1]);
    }

}
