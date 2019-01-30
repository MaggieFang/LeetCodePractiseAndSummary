package com.array;

import java.util.HashMap;

public class TwoSum {
    public static void main(String args[]) {
        int nums[] = new int[]{2, 7, 11, 15};
        int result[] = twoSumMap(nums, 26);
        for (int aResult : result) {
            System.out.print(aResult + ",");
        }

    }

    /**
     * KEYPOINTS:
     * <p>
     * （1）Map数据结构，k，v为（taget-num[i],i）
     * （2）鉴于map有containKey及containValue,且我们可以通过k找v，但v找k就得iterator了，
     * 所以对于num[i]，其期待值（taget-num[i]）作key，这样再遍历num后面时候，
     * 通过containKey及getValue就可以找到结果的Entry了
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *  for i = i to num.length:
     *      if map.containKey(num[i])
     *          return i and map.getValue(num[i])
     *      else
     *          put (target-num[i],i) into map
     * </code>
     * </pre>
     * TIME COMPLEXITY: O(n)
     * <p>
     * SPACE COMPLEXITY: O(n)
     * <p>
     *
     * @param nums   nums
     * @param target target
     * @return index
     */
    public static int[] twoSumMap(int[] nums, int target) {

        int result[] = new int[]{-1, -1};
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {  // 1,n
            if (map.containsKey(nums[i])) {  //1,(n-1)/2,
                result[0] = map.get(nums[i]); //1,(n-1)/2
                result[1] = i;   //1,(n-1)/2
                return result;
            } else {              //1,(n-1)/2
                map.put(target - nums[i], i);   //1,(n-1)/2
            }
        }
        return result;
    }


}
