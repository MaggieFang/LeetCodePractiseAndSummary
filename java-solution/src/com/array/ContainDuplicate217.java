package com.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 9/2/18
 * Talk is Cheap,Show me the Code.
 **/
public class ContainDuplicate217 {
    public static void main(String[] args) {
        int[] t1 = new int[]{1, 2, 3, 1};
        int[] t2 = new int[]{1, 2, 3, 4};
        int[] t3 = new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println(containsDuplicate(t1));
        System.out.println(containsDuplicate(t2));
        System.out.println(containsDuplicate(t3));
    }

    /**
     * KEYPOINTS:
     * <p>
     *   只需要计数某个元素是否已经计过；使用HasMap，以元素为key，次数为value则可，
     *   但此题不关心Value值（即次数），可以直接使用HashSet
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *      for i = 1 to n:
     *         if set contains num:
     *           return true
     *         else
     *            add num to set
*           return false
     * </code>
     * </pre>
     * TIME COMPLEXITY: O(n)
     * <p>
     * SPACE COMPLEXITY:O(n)
     * <p>
    **/
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
