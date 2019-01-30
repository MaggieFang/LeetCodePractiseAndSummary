package com.mianjing.google;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/11/19
 * Talk is Cheap,Show me the Code.
 **/
public class QuickSort {
    /**
     * KEYPOINTS:
     * <p>
     * </p>
     * TIME COMPLEXITY: T(n) = \theta(n)+ T(k)+ T(n-k-1), first term for partition, the latter two for recur,
     * k is the number of elem smaller than pivot.
     * worse, k  = 0, T(n) = theta(n)+ T(0)+ T(n-1) = O(n^2)
     * best, k = 2/n, T(n) = 2T(n/2)+ theta(n), use Master theorem O(nlogn) same as average
     * <p>
     * SPACE COMPLEXITY:
     * <p>
     **/
    public void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int pi = partition(nums, low, high);
            quickSort(nums, low, pi - 1);
            quickSort(nums, pi + 1, high);
        }
    }

    private int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low - 1;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] <= pivot) {
                i++;
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }

        nums[high] = nums[i + 1];
        nums[i + 1] = pivot;
        return i + 1;
    }
}
