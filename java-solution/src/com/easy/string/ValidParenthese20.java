package com.easy.string;

import java.util.Stack;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 9/21/18
 * Talk is Cheap,Show me the Code.
 **/
public class ValidParenthese20 {
    /**
     * KEYPOINTS:
     * <p>
     * a very good idea compare to the above solution.
     * When meet open blanket, just to push the close blanket that the open blanket need latter.
     * When meet close blanket, pop if it is the same with it.
     * if stack.isEmpty()|| stack.pop() != c return false.e.g case s=']', the stack is empty
     * and finally return stack.isEmpty(); e.g case s='[' we push a ']' in stack
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
    public static boolean isValidTrick(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '['){
                stack.push(']');
            }else if(c == '('){
                stack.push(')');
            }else if(c =='{'){
                stack.push('}');
            }else if(stack.isEmpty()|| stack.pop() != c){ // take care of this judge. e.g case ']',
                return false;
            }
        }
        return stack.isEmpty(); // case s = '['
    }

    public static boolean isValid(String s) {
        if (s == null || s.length() < 1) {
            return true;
        }

        if (s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            switch (c) {
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.isEmpty()) {  // maybe start with close bracket e.g. ")("
                        return false;
                    }
                    char pop = stack.pop();
                    if (pop == '(') {
                        break;
                    } else {
                        return false;
                    }

                case '}':
                    if (stack.isEmpty()) {
                        return false;
                    }
                    pop = stack.pop();
                    if (pop == '{') {
                        break;
                    } else {
                        return false;
                    }
                case ']':
                    if (stack.isEmpty()) {
                        return false;
                    }
                    pop = stack.pop();
                    if (pop == '[') {
                        break;
                    } else {
                        return false;
                    }
            }
            ++i;
        }
        return stack.isEmpty(); // maybe only open blankets "))"
    }


}
