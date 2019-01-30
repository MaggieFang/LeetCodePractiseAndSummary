package com.mianjing.fb;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/18/18
 * Talk is Cheap,Show me the Code.
 **/
public class CourseSchedule207 {
    /**
     * KEYPOINTS:
     * <p>
     *     topologicol sorting.
     *     to calculate the indegree of each course.(how many prerequisites) and then use a queue.
     *     从最基础的课程开始遍历，先把最基础的课程加入到queue，如果最后所有的课的indegree 都变成了0，就是true
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
    public boolean canFinish(int numCourse, int[][] pre) {
        Queue<Integer> q = new LinkedList<>();
        int[] degree = new int[numCourse];
        for (int[] p : pre) {
            degree[p[0]]++;
        }

        for (int i = 0; i < numCourse; i++) {
            if (degree[i] == 0) q.add(i);
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int[] p : pre) {
                if (p[1] == cur) {
                    if (--degree[p[0]] == 0) {
                        q.add(p[0]);
                    }
                }
            }
        }

        for (int d : degree) {
            if (d != 0) return false;
        }


        return true;
    }

}
