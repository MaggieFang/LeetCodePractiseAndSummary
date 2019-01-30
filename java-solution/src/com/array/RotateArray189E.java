package com.array;

public class RotateArray189E {

    /**
     * KEYPOINTS:
     * <p>
     * when we rotate the array k times, kelements from the back end of the array come to the front
     * and the rest of the elements from the front shift backwards.
     * So we firstly reverse all the elements of the array.
     * Then, reversing the first k elements followed by reversing the rest n-k elements.
     *
     * similar to revert string in word such as 'hello world' will be 'world hello'
     * revert all characters and revert the word self.
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     * </code>
     * </pre>
     * TIME COMPLEXITY:
     * <p>
     * SPACE COMPLEXITY:
     * <p>
     **/
    public void rotate(int[] A, int k) {
        int n = A.length;
        k = k % n;
        rotate(A, 0, n - 1);
        rotate(A, 0, k - 1);
        rotate(A, k, n - 1);

    }

    public void rotate(int A[], int i, int j) {
        while (i < j) {
            int tmp = A[i];
            A[i] = A[j];
            A[j] = tmp;
            i++;
            j--;
        }
    }

    /**
     * KEYPOINTS:
     * <p>
     * use extra space, the ith ele. will be int (i+k)/n position.
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     * </code>
     * </pre>
     * TIME COMPLEXITY:
     * <p>
     * SPACE COMPLEXITY:
     * <p>
     **/
    public void rotate1(int[] A, int k) {
        int n = A.length;
        int[] B = new int[n];
        for (int i = 0; i < n; i++) {
            B[(i + k) % n] = A[i];
        }
        for (int i = 0; i < n; i++) {
            A[i] = B[i];
        }
    }

    /**
     * KEYPOINTS:
     * <p>
     * do it brutefore.
     * rotate all the elements in k steps by rotating the elements by 1 unit in each step.
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     * </code>
     * </pre>
     * TIME COMPLEXITY:
     * <p>
     * SPACE COMPLEXITY:
     * <p>
     **/
    public void rotate2(int[] A, int k) {
        int i = 0;
        while (i < k) {
            int tmp = A[A.length - 1];
            //should iterate from end. Otherwise the number be same, e.g A[1] = A[0], A[2] = A[1],here A[1] already A[0]
            for (int t = A.length - 1; t > 0; t--) {
                A[t] = A[t - 1];
            }
            A[0] = tmp;
            i++;
        }
    }
}
