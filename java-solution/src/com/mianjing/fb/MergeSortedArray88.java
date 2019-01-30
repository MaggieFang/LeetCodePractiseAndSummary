package com.mianjing.fb;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 9/12/18
 * Talk is Cheap,Show me the Code.
 **/
public class MergeSortedArray88 {
    public static void main(String[] args) {

    }

    /**
     * KEYPOINTS:
     * <p>
     * This is a advance problem of MergeOriginal(),
     * So maybe we can use a temp array to store A,
     * and let A be the result array,trastravel temp and B as MergeOriginal()
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY: O(m+n)
     * <p>
     * SPACE COMPLEXITY: O(m)
     * <p>
     **/
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] temp = new int[m];
        for (int i = 0; i < m; i++) {
            temp[i] = nums1[i];
        }
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (temp[i] < nums2[j]) {
                nums1[k] = temp[i];
                ++k;
                ++i;
            } else {
                nums1[k] = nums2[j];
                ++k;
                ++j;
            }
        }
        while (i < m) {
            nums1[k] = temp[i];
            ++k;
            ++i;
        }

        while (j < nums2.length) {
            nums1[k] = nums2[j];
            ++k;
            ++j;
        }

    }

    /**
     * KEYPOINTS:
     * <p>
     * Wow. A good idea.
     * the first solution we use temp because the new comer B may cover A.
     * However. it wouldnot be a problem if We  rearrange them back forward.
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
    public void mergeBackForward(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 && j >= 0) {
            nums1[k--] = nums1[i] < nums2[j] ? nums2[j--] : nums1[i--];
        }
        while (j >= 0){
            nums1[k--] = nums2[j--];
        }

    }

    /**
     * KEYPOINTS:
     * <p>
     * 这只是leetcode88自己想到的一个变体，也就是A B都是刚好装满
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY: O(m+n)
     * <p>
     * SPACE COMPLEXITY:O(m+n)
     * <p>
     **/
    public void mergeOriginal(int[] A, int[] B) {
        int[] C = new int[A.length + B.length];
        int i = 0, j = 0, k = 0;
        while (i < A.length && j < B.length) {
            if (A[i] < B[j]) {
                C[k++] = A[i++];
            } else {
                C[k++] = B[j++];
            }
        }
        while (i < A.length) {
            C[k] = A[i];
            ++k;
            ++i;
        }

        while (j < B.length) {
            C[k] = B[j];
            ++k;
            ++j;
        }


    }
}
