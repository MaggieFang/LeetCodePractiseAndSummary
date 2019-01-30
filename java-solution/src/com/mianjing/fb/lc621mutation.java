package com.mianjing.fb;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/8/18
 * Talk is Cheap,Show me the Code.
 **/

import java.util.HashMap;
import java.util.List;

/**
 * Problem Desc:
 * lc 621变种，不再是让自己安排任务处理时间最小，而是给定task序列和cooldown，求完成这个顺序需要的时间。
 * 且每个task都有一个任意长度的名字（可以为空）
 * 举例：
 * ABAABC cooldown = 3
 * AB--A---ABC 答案= 11
 * 问了当task的种类数量<<cooldown的最大值 和 cooldown可以非常大，task的种类数量很少 两种不同情况下的空间最优的做法，分别写了实现
 */

/**
 * when the cooltime is large, the task size is small, we use hasmap to map the <task, handling time>,
 * when traversav a new task, check it and update the curtime. O(task.size)
 *
 *
 */
public class lc621mutation {
    public int timeNeeded(List<String> task, int coolTime) {
        if (task == null || task.size() == 0) {
            return 0;
        }
        if (coolTime == 0) {
            return task.size();
        }

        HashMap<String, Integer> map = new HashMap<>();
        int curTime = 0;
        for (String t : task) {
            if (map.containsKey(t)) {
                int lastTime = map.get(t);
                curTime = Math.max(lastTime + coolTime + 1, curTime);
            } else {
                curTime++;
            }
            map.put(t, curTime);
        }
        return curTime;
    }


}
