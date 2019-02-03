package com.facebook;

import com.basicStructure.Interval;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/7/18
 * Talk is Cheap,Show me the Code.
 **/
public class MeetingRoom253M {

    /**
     * KEYPOINTS:
     * <p>
     * Q: 1) e.g if the end time == the next start time, can they use the same room , e.g.[1,5][5,6] yes;
     * <p>
     * 1.Sortd the interval with startTime
     * 2. init a min_heap to save the end time that are processing
     * 3. add the first item to the heap
     * 4. interate from 1 to n-1; to check if the startTime >= heap.peek();
     * if yes,then it can be handle by the existing room. so remove the topmost, and add this item to the heap, indicating it is processing.
     * if No, just add this item to the heap.
     * 5. the result will be the heap.size();
     * <p>
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY: O(NlogN): 1) the sort algorithm O(NlogN) 2) the min_heap ,the worst case is linear, O(n), average is O(logN)
     * <p>
     * <p>
     * SPACE COMPLEXITY:: O(N) because we construct the min-heap and that can contain NN elements in the worst case
     * <p>
     **/
    public int minMeetingRoomsMinHeap(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
// 跟下面一样 ，默认就是最小堆
//        PriorityQueue<Integer> minHeap = new PriorityQueue<>(intervals.length, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1 - o2;
//            }
//        });

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(intervals[0].end);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= minHeap.peek()) {
                minHeap.poll();
            }
            minHeap.add(intervals[i].end);
        }
        return minHeap.size();


    }

    /**
     * KEYPOINTS:
     * <p>
     *   (1,10),(2,7) (3,19),(8,12),(10,20),(11,13)
     *   we find the smallest start time
     *   1     2     3    8            10        11
     *   10(X) 7(X)  19  reuse(12)   reuse(20)   13
     *   so we can sort start time and end time seperately.
     *   and two pointer pointer to the start and end time
     *   and traverse the startTime, if the ends points(the earliest end one can be use) value is <= startTime. Then it an be used.
     *   and the end time pointer move next;
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
    public int minMeetingRooms(Interval[] in) {
        if(in == null || in.length== 0){
            return 0;
        }

        Interval[] ends = Arrays.copyOf(in,in.length);
        Arrays.sort(in, new Comparator<Interval>(){
            @Override
            public int compare(Interval o1,Interval o2){
                return o1.start - o2.start;
            }
        });

        Arrays.sort(ends, new Comparator<Interval>(){
            @Override
            public int compare(Interval o1,Interval o2){
                return o1.end  - o2.end;
            }
        });
        int s = 0;
        int e = 0;
        int result = 0;
        while(s < in.length){
            if(in[s].start < ends[e].end){
                result++;
            }else{
                e++;
            }
            s++;
        }
        return result;
    }

}



