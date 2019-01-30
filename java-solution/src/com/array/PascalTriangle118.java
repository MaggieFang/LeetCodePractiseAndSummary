package com.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 9/16/18
 * Talk is Cheap,Show me the Code.
 **/
public class PascalTriangle118 {
    public static void main(String[] args) {

    }

    /**
     * KEYPOINTS:
     * <p>
     * use the current array to generate the next array. How?
     * the first and last element are 1, the middle ones are the neighbouring two sum.
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY: O(n^2)
     * <p>
     * SPACE COMPLEXITY:O(n^2)
     * <p>
     **/
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }

        ArrayList<Integer> zero = new ArrayList<>();
        zero.add(1);
        result.add(zero);

        for (int i = 1; i < numRows; i++) {
            List<Integer> current = new ArrayList<>();
            List<Integer> last = result.get(result.size() - 1);
            current.add(1);
            for (int j = 1; j < last.size(); j++) {
                current.add(last.get(j) + last.get(j - 1));
            }
            current.add(1);
            result.add(current);
        }
        return result;

    }
}
