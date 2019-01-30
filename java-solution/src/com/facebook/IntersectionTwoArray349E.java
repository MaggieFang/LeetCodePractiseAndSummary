package com.facebook;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/9/18
 * Talk is Cheap,Show me the Code.
 **/
public class IntersectionTwoArray349E {
    public int[] intersection(int[] num1, int[] num2) {
        if (num1 == null || num2 == null || num1.length == 0 || num2.length == 0) {
            return null;
        }
        HashSet<Integer> set = new HashSet<>();
        if (num1.length < num2.length) {
            for (int i : num1) {
                set.add(i);
            }
        } else {
            for (int i : num2) {
                set.add(i);
            }
        }

        HashSet<Integer> list = new HashSet<>();
        if (num1.length < num2.length) {
            for (int i : num2) {
                if (set.contains(i)) {
                    list.add(i);
                }
            }
        } else {
            for (int i : num1) {
                if (set.contains(i)) {
                    list.add(i);
                }
            }
        }
        int[] result = new int[list.size()];
        int i = 0;
        for (Integer item : list) {
            result[i++] = item;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 2, 1};
        int[] B = new int[]{2, 2};
        IntersectionTwoArray349E test = new IntersectionTwoArray349E();
        System.out.println(test.intersection(A, B));
    }
}
