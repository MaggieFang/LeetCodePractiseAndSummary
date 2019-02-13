package com.mianjing.gou;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-02-12
 * Talk is cheap,show me the Code.
 **/
public class FindFrequencyNumInSortedArray {
    //一个sorted array，返回target input 的frequency. 就还是用binary search做

    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     *1) Use Binary search to get index of the first occurrence of x in arr[]. Let the index of the first occurrence be i.
     * 2) Use Binary search to get index of the last occurrence of x in arr[]. Let the index of the last occurrence be j.
     * 3) Return (j – i + 1);
     * </p>
     * TIME COMPLEXITY: O(logN)
     * SPACE COMPLEXITY:
     * </p>
     **/
    public int getFreq(int[] A, int target) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int i = firstIndex(A, target);
        if (i == -1) {
            return 0;
        }
        int j = lastIndex(A, target);
        return j - i + 1;
    }

    private int firstIndex(int[] A, int target) {
        int low = 0;
        int high = A.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (A[mid] == target && (mid == 0 || target > A[mid - 1])) {
                return mid;
            } else if (target > A[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    private int lastIndex(int[] A, int target) {
        int low = 0;
        int high = A.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (A[mid] == target && (mid == A.length - 1 || target < A[mid + 1])) {
                return mid;
            } else if (target < A[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindFrequencyNumInSortedArray t = new FindFrequencyNumInSortedArray();
        int arr[] = {1, 2, 2, 3, 3, 3, 3};
        int x = 3;
        System.out.println(t.getFreq(arr, x));
    }
}
