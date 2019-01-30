package com.google;

import java.util.Stack;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/13/19
 * Talk is Cheap,Show me the Code.
 **/
public class BasicCalculatorII227M {
    /**
     * KEYPOINTS:
     * <p>
     *   由于存在运算优先级，我们采取的措施是使用一个栈保存数字，如果该数字之前的符号是加或减，那么把当前数字压入栈中，注意如果是减号，则加入相反数;
     *   如果之前的符号是乘或除，那么从栈顶取出一个数字和当前数字进行乘或除的运算，再把结果压入栈中，那么完成一遍遍历后，所有的乘或除都运算完了，
     *   再把栈中所有的数字都加起来就是最终结果了
     * </p>
     * TIME COMPLEXITY: O(n)
     * <p>
     * SPACE COMPLEXITY: O(n)
     * <p>
     **/
    public int calculate(String s) {
        int len;
        if (s == null || (len = s.length()) == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char preOp = '+';
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            //这里必须是if，不能是上一个的else if,不然1+2的2不能被推进stack
            if ((!Character.isDigit(s.charAt(i)) && ' ' != s.charAt(i)) || i == len - 1) {
                if (preOp == '+') {
                    stack.push(num);
                } else if (preOp == '-') {
                    stack.push(-num);
                } else if (preOp == '*') {
                    stack.push(num * stack.pop());
                } else if (preOp == '/') {
                    stack.push(stack.pop() / num);
                }
                num = 0;
                preOp = s.charAt(i);
            }
        }

        int re = 0;
        for (int i : stack) {
            re += i;
        }
        return re;
    }

}
