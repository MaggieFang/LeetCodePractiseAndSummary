package com.oscar;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/19/19
 * Talk is Cheap,Show me the Code.
 **/
public class SimplifyPath71M {
    public String simplifyPath(String path) {
        int cnt = 0;
        StringBuilder ans = new StringBuilder();
        String[] sp = path.split("/");
        HashSet<String> skip = new HashSet<>(Arrays.asList("/", ".", ""));
        for (int i = sp.length - 1; i >= 0; i--) {
            String s = sp[i];
            if (skip.contains(s)) continue;
            if (s.equals("..")) {
                cnt++;
            } else if (cnt > 0) {
                cnt--;
            } else {
                ans.insert(0, "/" + s);
            }
        }
        return ans.length() == 0 ? "/" : ans.toString();

    }

    public String simplifyPathUsStack(String path) {
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        HashSet<String> skip = new HashSet<>(Arrays.asList(".", "..", ""));
        String[] sp = path.split("/");
        for (String s : sp) {
            if ("..".equals(s) && !stack.isEmpty()) stack.pop();
            if (!skip.contains(s)) {
                stack.add(s);
            }
        }

        while (!stack.isEmpty()) {
            sb.insert(0, '/' + stack.pop());
        }
        return sb.length() == 0 ? "/" : sb.toString();

    }

    public static void main(String[] args) {
        SimplifyPath71M t = new SimplifyPath71M();
        System.out.println(t.simplifyPath("/home//foo/"));
    }
}
