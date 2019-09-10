package com.appfolio;


/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-08-23
 **/
public class DigitalMatch {
    public static void main(String[] args) {
        System.out.println(sumContinue("1122"));
        System.out.println(sumContinue("111222"));
        System.out.println(sumContinue("311223"));

        System.out.println(match("1212", 2));
    }

    /**
     * Clarification:
     * 给一个String s, 全是由数字组成，返回所有连续出现的数字的和，例子："1122" ---> 3, "111222" ---> 6;‍‌‍‍‌‍‍‌‌‍‍‌‍‍‍‍‌‌
     * 第二个例子返回6因为1和2是两次重复，每次重复都要算上。
     * 两个followup: 1. 如果assume这个string是首位相连的，例子: "311223" ---> 6, "111" ---> 3
     * 2. 如果不是看两个连续的，而是看间隔s.length / 2的，比如1212 ---> 5(index0 and index 2, index1 and index‍‌‍‍‌‍‍‌‌‍‍‌‍‍‍‍‌‌3, index 3 and index 1)，这样就是看char at i and (i + length / 2) % length是否一样就可以
     * </p>
     * Keypoints:
     *
     * </p>
     * TIME COMPLEXITY:
     * SPACE COMPLEXITY:
     * </p>
     **/
    private static int sumContinue(String str) {
        int sum = 0;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i - 1) == str.charAt(i)) {
                sum += str.charAt(i) - '0';
            }
        }
        // check 首尾相连情况
//        if(str.charAt(0) == str.charAt(str.length() - 1)){
//            sum += str.charAt(0) - '0';
//        }
        return sum;
    }


    /**
     * @param str digital string
     * @param step step
     * @return
     */
    public static int match(String str, int step) {
        int r = 0;
        for (int i = 0; i < str.length(); i++) {
            char c1 = str.charAt(i);
            char c2 = str.charAt((i + step) % str.length()); //(i + step) % str.length() !!!
            if (c1 == c2) {
                r += c1 - '0';
            }
        }
        return r;
    }

}
