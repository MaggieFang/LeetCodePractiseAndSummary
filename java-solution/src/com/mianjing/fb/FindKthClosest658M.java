package com.mianjing.fb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/21/18
 * Talk is Cheap,Show me the Code.
 **/
public class FindKthClosest658M {
    /**
     * KEYPOINTS:
     * <p>
     * If the target x is less or equal than the first element in the sorted array, the first k elements are the result.
     * Similarly, if the target x is more or equal than the last element in the sorted array, the last k elements are the result.
     * Otherwise, we can use binary search to find the index of the element, which is equal (when this list has x) or a little bit larger than x (when this list does not have it). Then set low to its left k-1 position, and high to the right k-1 position of this index as a start. The desired k numbers must in this rang [index-k-1, index+k-1]. So we can shrink this range to get the result using the following rules.
     * If low reaches the lowest index 0 or the low element is closer to x than the high element, decrease the high index.
     * If high reaches to the highest index arr.size()-1 or it is nearer to x than the low element, increase the low index.
     * The looping ends when there are exactly k elements in [low, high], the subList of which is the result.
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY:
     * <p>
     * SPACE COMPLEXITY:
     * <p>
     **/
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        int n = arr.length;
        if (x < arr[0]) {
            for (int i = 0; i < k && i < n; i++) {
                ans.add(arr[i]);
            }
        } else if (x > arr[n - 1]) {
            for (int i = n - k; i < n; i++) {
                ans.add(arr[i]);
            }

        } else {
            int index = Arrays.binarySearch(arr, x);
            if (index < 0) {
                index = -index - 1;
            }
            int low = Math.max(index - k, 0);
            int hi = Math.min(index + k - 1, n - 1);
            while (hi - low + 1 > k) {
                int dif1 = Math.abs(x - arr[low]);
                int dif2 = Math.abs(x - arr[hi]);
                if (dif1 > dif2) {
                    low = low + 1;
                } else {  // I think there is some problem here. if the dif is same.we cannot decide which side to move
                    hi = hi - 1;
                }
            }
            for (int i = low; i <= hi; i++) {
                ans.add(arr[i]);
            }
        }

        return ans;
    }
    /**
     * KEYPOINTS:
     * <p>
     *    us priorityQueue
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY:
     * <p>
     * SPACE COMPLEXITY:
     * <p>
    **/
    public List<Integer> findClosestElements2(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        return ans;
    }

    }
