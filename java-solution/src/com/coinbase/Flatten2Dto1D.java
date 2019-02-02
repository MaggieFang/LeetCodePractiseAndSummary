package com.coinbase;

import javax.swing.plaf.metal.MetalTabbedPaneUI;
import java.util.ArrayList;
import java.util.List;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-01-30
 * Talk is Cheap,Show me the Code.
 **/
public class Flatten2Dto1D {
    /**
     * Input: [[1, 2, 3], [4, 5], [], [7, 8, 9]]
     * Output: [1, 4, 7, 2, 5, 8, 3, 9]
     */
    public static List<Integer> flatten(int[][] A) {
        int m = A.length;
        List<Integer> ans = new ArrayList<>();
        int max = 0;
        for (int[] e : A) {
            max = Math.max(e.length, max);
        }
        int cnt = 0;

        while (cnt < max) {
            for (int i = 0; i < m; i++) {
                if (A[i].length > cnt) {
                    ans.add(A[i][cnt]);
                }
            }
            cnt++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(flatten(new int[][]{{1, 2, 3}, {4, 5}, {}, {7, 8, 9}}));
    }
}
