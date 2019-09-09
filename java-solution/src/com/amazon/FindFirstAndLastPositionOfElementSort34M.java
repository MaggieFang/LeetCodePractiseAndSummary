package com.amazon;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 11/6/18
 * Talk is Cheap,Show me the Code.
 **/
public class FindFirstAndLastPositionOfElementSort34M {
    // 二刷，use binary search to find the target index, then move target left and right to find the start and end;
    public int[] searchRange(int[] nums, int target) {
        int i = 0;
        int j = nums.length;
        int t = -1;
        int[] ans = new int[]{-1, -1}; // init with -1,-1
        while (i < j) {
            int mid = i + ((j - i) >> 1);
            if (nums[mid] == target) {
                t = mid;
                break;
            } else if (nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        if (t != -1) {
            ans[0] = ans[1] = t;
            int tmp = t;
            while (--tmp >= 0 && nums[tmp] == target) {
                ans[0] = tmp;
            }
            tmp = t;
            while (++tmp < nums.length && nums[tmp] == target) {
                ans[1] = tmp;
            }

        }
        return ans;
    }


    public static int[] searchRange1(int[] A, int target) {
        int start = firstGreaterEqual(A, target);
        if (start == A.length || A[start] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{start, firstGreaterEqual(A, target + 1) - 1};
    }

    //find the first number that is greater than or equal to target.
    //could return A.length if target is greater than A[A.length-1].
    private static int firstGreaterEqual(int[] A, int target) {
        int low = 0, high = A.length;
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            //low <= mid < high
            if (A[mid] < target) {
                low = mid + 1;
            } else {
                //should not be mid-1 when A[mid]==target.
                //could be mid even if A[mid]>target because mid<high.
                high = mid;
            }
        }
        return low;
    }
}
