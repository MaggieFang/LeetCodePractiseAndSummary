package com.fb;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-03-28
 * Talk is cheap,show me the Code.
 **/
public class MultiplyStrings43M {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * Start from right to left, perform multiplication on every pair of digits, and add them together.
     * `num1[i] * num2[j]` will be placed at indices `[i + j`, `i + j + 1]`
     * greateast explaination https://leetcode.com/problems/multiply-strings/discuss/17605/Easiest-JAVA-Solution-with-Graph-Explanation
     *
     * </p>
     * TIME COMPLEXITY: O(n1 + n2)
     * SPACE COMPLEXITY: O(n1+n2)
     * </p>
     **/
    public String multiply(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        int[] res = new int[n1 + n2];

        for (int i = n1 - 1; i >= 0; i--) {
            int v1 = num1.charAt(i) - '0';
            for (int j = n2 - 1; j >= 0; j--) {
                int v2 = num2.charAt(j) - '0';
                int sum = v1 * v2;
                sum += (res[i + j] * 10 + res[i + j + 1]);
                res[i + j] = sum / 10;
                res[i + j + 1] = sum % 10;

            }
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < res.length && res[i] == 0) {
            i++;
        }
        while (i < res.length) {
            sb.append(res[i++]);
        }
        return sb.length() == 0 ? "0" : sb.toString(); // don't forget if num1 or num2 0

    }
}
