package com.mianjing.google;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-02-06
 * Talk is cheap,show me the Code.
 **/
public class DecodeWithCount {
    /**
     * input: aaaaabbbbbbbbccc
     * output:  5xa8xb3xc
     */
    /**
     * KEYPOINTS:
     * 其实就是统计数一个字符串中连续出现的字符数 跟ExpressiveWords809M 解法类似
     * </p>
     * TIME COMPLEXITY:
     * <p>
     * SPACE COMPLEXITY:
     * <p>
     **/
    public String encode(String s) {
        int pre = -1;
        int cnt = 0;
        StringBuilder ans = new StringBuilder();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (i == n - 1 || s.charAt(i) != s.charAt(i + 1)) {
                ans.append(i - pre).append('x').append(s.charAt(i));
                pre = i;
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        DecodeWithCount t = new DecodeWithCount();
        System.out.println(t.encode("aaaaabbbbbbbbccc"));
        System.out.println(t.encode("a"));
        System.out.println(t.encode("abc"));
        System.out.println(t.encode("aaaaa"));
        System.out.println(t.encode("abb"));


    }
}
