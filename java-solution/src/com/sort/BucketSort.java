package com.sort;

import java.util.Random;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/16/19
 * Talk is Cheap,Show me the Code.
 **/
public class BucketSort {
    /**
     * https://www.geeksforgeeks.org/bucket-sort-2/
     * Bucket sort is mainly useful when input is uniformly distributed over a range. For example,
     * Sort a large set of floating point numbers which are in range from 0.0 to 1.0 and
     * are uniformly distributed across the range. How do we sort the numbers efficiently?
     * bucketSort(arr[], n)
     * 1) Create n empty buckets (Or lists).
     * 2) Do following for every array element arr[i].
     * .......a) Insert arr[i] into bucket[n*array[i]]
     * 3) Sort individual buckets using insertion sort.
     * 4) Concatenate all sorted buckets.
     */


    public static int[] bucketSort(int[] arr, int maxValue) {
        int i, j;
        int[] bucket = new int[maxValue];
        for (i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }

        int k = 0;
        for (i = 0; i < bucket.length; i++) {
            for (j = 0; j < bucket[i]; j++) {
                arr[k++] = i;
            }
        }
        return arr;
    }


    public static void main(String args[]) {
        Random random = new Random();
        int N = 20;
        int[] sequence = new int[N];

        for (int i = 0; i < N; i++)
            sequence[i] = Math.abs(random.nextInt(100));

        for (int q : sequence) {
            System.out.print(q + "\t");
        }
        int maxValue = 100;

        System.out.println();
        sequence = bucketSort(sequence, maxValue);
        for (int q : sequence) {
            System.out.print(q + "\t");
        }

    }


}
