package com.test;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 9/24/18
 * Talk is Cheap,Show me the Code.
 **/
public class QuickSort {
    // a good article for QuickSort http://bubkoo.com/2014/01/12/sort-algorithm/quick-sort/

    public static void main(String[] args) {
        int[] A = {2, -1, 33, 66, 19, 0, -44, 8};
        quickSort(A, 0, A.length - 1);
        for (int i : A
                ) {
            System.out.print(i + "\t");
        }

    }

    public static void quickSort(int[] A, int low, int high) {
        if (low < high) {
            int index = partition(A, low, high);
            quickSort(A, low, index - 1);
            quickSort(A, index + 1, high);
        }
    }

    /**
     * Since you want to move the number less than pivot to the left side. So we can hold two pointers.
     * One storeIndex showed the position to put the next smaller than pivot element. and i for traverse.
     * When we keep move on storeIndex. the left side are all smaller elements.
     * and the storeIndex is the right pos for pivot
     * The last step, dont forget to swap the pivot with the storeIndex element.
     */

    public static int partition(int[] A, int low, int high) {
        int storeIndex = low;
        int pivot = A[high];
        for (int i = low; i < high; i++) {
            if (A[i] < pivot) {
                int tmp = A[storeIndex];
                A[storeIndex++] = A[i];
                A[i] = tmp;

            }
        }
        A[high] = A[storeIndex];
        A[storeIndex] = pivot;
        return storeIndex;
    }
}
