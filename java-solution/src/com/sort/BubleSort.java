package com.sort;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/15/19
 * Talk is Cheap,Show me the Code.
 **/
public class BubleSort {
    /**
     * KEYPOINTS:
     * <p>
     * </p>
     * TIME COMPLEXITY:
     * Worst and Average Case Time Complexity: O(n*n). Worst case occurs when array is reverse sorted.
     * Best Case Time Complexity: O(n). Best case occurs when array is already sorted.
     * <p>
     * SPACE COMPLEXITY:
     *
     * <p>
     **/
    public int[] bubleImprove(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1 ; i++) {
            boolean swap = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    swap = true;
                }
            }
            if (!swap) return arr;
        }

        return arr;
    }

    /**
     * Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements
     * if they are in wrong order.
     **/
    public int[] buble(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        for (int i : arr) {
            System.out.print(i + "\t");
        }
        return arr;
    }

    public static void main(String[] args){

    }


}
