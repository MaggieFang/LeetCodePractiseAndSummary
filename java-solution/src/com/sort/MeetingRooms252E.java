package com.sort;

import com.basicStructure.Interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/2/19
 * Talk is Cheap,Show me the Code.
 **/
public class MeetingRooms252E {
    public boolean canAttendMeetingsQ(Interval[] in) {
        PriorityQueue<Interval> q = new PriorityQueue<>(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        for (Interval i : in) {
            q.add(i);
        }

        while (!q.isEmpty()) {
            int end = q.poll().end;
            if (q.peek() != null) {
                int nextStart = q.peek().start;
                if (end > nextStart) {
                    return false;
                }
            }

        }
        return true;

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

}
