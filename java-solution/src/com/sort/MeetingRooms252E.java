package com.sort;

import com.basicStructure.Interval;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/2/19
 * Talk is Cheap,Show me the Code.
 **/
public class MeetingRooms252E {

    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (int[] o1, int[] o2) -> o1[0] - o2[0]);
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i + 1][0] < intervals[i][1]) {
                return false;
            }
        }
        return true;
        /**the second implementation.**/
//        PriorityQueue<int[]> q = new PriorityQueue<>((int[] o1, int[] o2) -> o1[0] - o2[0]);
//        Collections.addAll(q, intervals);
//        int[] pri = null;
//        while (!q.isEmpty()) {
//            int[] cur = q.poll();
//            if (pri != null && cur[0] < pri[1]) {
//                return false;
//            }
//            pri = cur;
//        }
//
//        return true;

    }

    public boolean canAttendMeetings(Interval[] in) {
        int[] start = new int[in.length];
        int[] end = new int[in.length];

        for (int i = 0; i < in.length; i++) {
            start[i] = in[i].start;
            end[i] = in[i].end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        for (int i = 0; i < start.length - 1; i++) {
            if (start[i + 1] < end[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {


    }
}
