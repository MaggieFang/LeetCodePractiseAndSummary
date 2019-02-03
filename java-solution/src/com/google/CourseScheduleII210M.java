package com.google;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-02-02
 * Talk is Cheap,Show me the Code.
 **/
public class CourseScheduleII210M {
    //延续207的做法，从最基础的算 indgree
    public int[] findOrder(int num, int[][] pre) {
        int[] degree = new int[num];
        int[] ans = new int[num];
        int idx = 0;
        for (int[] p : pre) {
            degree[p[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < num; i++) {
            if (degree[i] == 0) {
                ans[idx++] = i;
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int[] p : pre) {
                if (p[1] == cur) {
                    degree[p[0]]--;
                    if (degree[p[0]] == 0) {
                        ans[idx++] = p[0];
                        q.add(p[0]);
                    }
                }
            }
        }

//        for (int i : degree) { // 还是处理可能存在环的情况，不然直接返回的ans都是填充了0的，[0,0,0..],返回list就不存在这问题
//            if (i != 0) return new int[0];
//        }
        if(idx == num)  return ans;
        return new int[0];
    }

    //先建立下adj关系，方便在q过程中处理减少indgree对全局pre的循环，而是只循环他adj，时间快了很多
    public int[] findOrder2(int num, int[][] pre) {
        ArrayList<Integer>[] graph = new ArrayList[num];
        int[] degree = new int[num];
        LinkedList<Integer> q = new LinkedList<>();
        int[] ans = new int[num];
        for (int[] p : pre) {
            degree[p[0]]++;
            if (graph[p[1]] == null) {
                graph[p[1]] = new ArrayList<>();
            }
            graph[p[1]].add(p[0]);
        }

        int id = 0;
        for (int i = 0; i < num; i++) {
            if (degree[i] == 0) {
                q.add(i);
                ans[id++] = i;
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            List<Integer> adj = graph[cur];
            if (adj == null) continue;
            for (int i : adj) {
                degree[i]--;
                if (degree[i] == 0) {
                    q.add(i);
                    ans[id++] = i;
                }
            }
        }

        if(id == num) return  ans;
        return new int[0];

    }
}
