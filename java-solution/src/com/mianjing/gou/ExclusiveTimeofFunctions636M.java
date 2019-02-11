package com.mianjing.gou;

import java.util.List;
import java.util.Stack;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/12/19
 * Talk is Cheap,Show me the Code.
 **/
public class ExclusiveTimeofFunctions636M {
    /**
     * KEYPOINTS:
     * <p>
     * 首先要弄明白一点：当遍历到logs中的某个字符串时，无论它是begin还是end，当前位于栈顶的元素都会占用
     * “当前字符串的timePoint-之前字符串的timePoint”(end的话还要+1)
     * functionId:   0  1  2   2   1    0
     * begin/end:   {  {   {   }   }    }
     * timeItem:    0  1  2   3   4    5
     * 0 被push进栈后，接下来遍历到 1 start 1，那么 0~1 的时间是被栈顶元素 0 占用的。接下来 1 被push进栈，遍历到 2 start 2，
     * 那么 1~2 的时间是被栈顶元素 1 占用的。接下来 2 被push进栈，遍历到 2 end 3，那么 2~3 的时间是被栈顶元素 2 占用的。
     * 接下来pop出 2 ，遍历到 1 end 4，那么3~4的时间是栈顶元素 1 占用的。接下来pop出 1 ，遍历到 0 end 5，
     * 那么 4~5 的时间是栈顶元素 0 占用的。
     * 所以算法的关键在于：拿到上一个log的 start/stop time 设为prev，再拿到当前 log 的 start/stop time ，计算出两个time之间的时间差
     * </p>
     * TIME COMPLEXITY:
     * <p>
     * SPACE COMPLEXITY:
     * <p>
     **/
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];
        int prev = 0;
        for (int i = 0; i < logs.size(); i++) {
            String[] sp = logs.get(i).split(":");
            int id = Integer.parseInt(sp[0]);
            String type = sp[1];
            int time = Integer.parseInt(sp[2]);
            if ("start".equals(type)) {
                if (!stack.isEmpty()) {
                    ans[stack.peek()] += time - prev;
                }
                stack.push(id);
                prev = time;
            } else {
                ans[stack.pop()] += time - prev + 1;
                prev = time + 1;
            }
        }
        return ans;
    }


}

