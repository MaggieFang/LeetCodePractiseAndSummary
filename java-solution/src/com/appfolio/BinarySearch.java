package com.appfolio;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-08-21
 **/
public class BinarySearch {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     *
     * </p>
     * TIME COMPLEXITY: O(NlogN)
     * SPACE COMPLEXITY:
     * </p>
     **/
    public static int iterativeImpl(int[] arr, int target) {
        if (arr == null || arr.length == 0) return -1;
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return -1;
    }

    public static int recurImpl(int[] arr, int target, int left, int right) {
        if (left > right) return -1;
        int mid = left + ((right - left) >> 1);
        if (arr[mid] == target) return mid;
        if (arr[mid] < target) {
            return recurImpl(arr, target, mid + 1, right);
        } else {
            return recurImpl(arr, target, left, mid - 1);
        }
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 4, 10, 40};
        System.out.println(iterativeImpl(arr, 9));
        System.out.println(recurImpl(arr, 9, 0, arr.length - 1));
    }
}
