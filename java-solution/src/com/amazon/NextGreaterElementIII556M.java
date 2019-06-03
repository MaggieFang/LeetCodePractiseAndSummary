package com.amazon;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-06-02
 **/
public class NextGreaterElementIII556M {
    /**
     * Clarification:
     *  input 12443322  output 13222344
     * </p>
     * Keypoints:
     *  from right to left. find the element the before to fall down. e.g 12443322 is 2 in index 1.
     *  then swap it with the mininum of the right part(not always the last one,maybe equals).
     *  then reverse the right part;
     * </p>
     * TIME COMPLEXITY: O(n)
     * SPACE COMPLEXITY: O(n)
     * </p>
     **/
    public int nextGreaterElement(int n) {
        char[] a = ("" + n).toCharArray();// good
        int i = a.length - 2;
        while (i >= 0 && a[i] >= a[i + 1]) i--;
        if (i < 0) return -1;

        int j = a.length - 1;
        while (j >= i && a[j] <= a[i]) j--;
        swap(i, j, a);
        reverse(a, i + 1);

        try {
            return Integer.parseInt(new String(a)); // maybe out of range.
        } catch (Exception ew) {
            return -1;
        }

    }

    private void reverse(char[] a, int start) {
        int left = start;
        int right = a.length - 1;
        while (left < right) {
            swap(left, right, a);
            left++;
            right--;
        }
    }

    private void swap(int i, int j, char[] a) {
        char tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

}
