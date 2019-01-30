package com.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/2/19
 * Talk is Cheap,Show me the Code.
 **/
public class FindAllNumbersDisappearedinArray448E {

    /**
     * The basic idea is that we iterate through the input array and mark elements as negative
     * using nums[nums[i] -1] = -nums[nums[i]-1]. In this way all the numbers that we have seen will
     * be marked as negative. In the second iteration, if a value is not marked as negative,
     * it implies we have never seen that index before, so just add it to the return list.
     **/
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i : nums) {
            i = Math.abs(i);
            if (nums[i - 1] > 0) {
                nums[i - 1] = -nums[i - 1]; // be the negative of its original.since we  use it future.if we just choose -1 ,we may miss the original
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ans.add(i + 1);
            }
        }
        return ans;
    }

    public List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }

        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                ans.add(i);
            }
        }
        return ans;
    }
}
