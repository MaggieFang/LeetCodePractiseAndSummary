package com.mianjing.fb;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/18/18
 * Talk is Cheap,Show me the Code.
 **/
public class MaxsumThreeNonOverlap689 {
    /**
     * KEYPOINTS:
     * <p>
     *https://www.geeksforgeeks.org/max-sum-of-m-non-overlapping-subarrays-of-size-k/
     * 1. We create a presum array, which contains in each index sum of all elements from ‘index‘ to ‘index + K’ in the given array. And size of the sum array will be n+1-k.
     2. Now if we include the subarray of size k, then we can not include any of the elements of that subarray again in any other subarray as it will create overlapping subarrays. So we make recursive call by excluding the k elements of included subarray.
     3. if we exclude a subarray then we can use the next k-1 elements of that subarray in other subarrays so we will make recursive call by just excluding the first element of that subarray.
     4. At last return the max(included sum, excluded sum).
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
    static void calculatePresumArray(int presum[],
                                     int arr[],
                                     int n, int k)
    {
        for (int i = 0; i < k; i++)
            presum[0] += arr[i];

        // store sum of array index i to i+k
        // in presum array at index i of it.
        for (int i = 1; i <= n - k; i++)
            presum[i] += presum[i - 1] + arr[i + k - 1] -
                    arr[i - 1];
    }

    // calculating maximum sum of
// m non overlapping array
    static int maxSumMnonOverlappingSubarray(int presum[],
                                             int m, int size,
                                             int k, int start)
    {
        // if m is zero then no need
        // any array of any size so
        // return 0.
        if (m == 0)
            return 0;

        // if start is greater then the
        // size of presum array return 0.
        if (start > size - 1)
            return 0;

        // if including subarray of size k
        int includeMax = presum[start] +
                maxSumMnonOverlappingSubarray(presum,
                        m - 1, size, k, start + k);

        // if excluding element and searching
        // in all next possible subarrays
        int excludeMax =
                maxSumMnonOverlappingSubarray(presum,
                        m, size, k, start + 1);

        // return max
        return Math.max(includeMax, excludeMax);
    }
}
