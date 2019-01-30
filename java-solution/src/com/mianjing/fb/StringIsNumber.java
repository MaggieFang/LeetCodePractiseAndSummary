package com.mianjing.fb;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/17/18
 * Talk is Cheap,Show me the Code.
 **/
public class StringIsNumber {
    /**
     * KEYPOINTS:
     * <p>
     * 给一个字符串判断是不是数字，注意考虑负数和小数就行了
     * 小数点只能出现一次，确定00开头这种算吗？ 例如"00.21",".222"
     * 科学表达方式Scientific Computing  1e10;
     * 负数可以吗
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY:
     * <p>
     * SPACE COMPLEXITY:
     * <p>
     **/
    public static boolean isNumber(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i == 0 && c == '-') {
                continue;
            }

            if (Character.isDigit(c) || (c == '.' && ++count <= 1)) {
                continue;
            }else {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] s) {
        String A = "abc";
        String B = "2.b.c";
        String C = ".001";
        String D = ".00.11";

        String E = "-1.2222";
        System.out.println(isNumber(A));
        System.out.println(isNumber(B));
        System.out.println(isNumber(C));
        System.out.println(isNumber(D));
        System.out.println(isNumber(E));
    }
}
