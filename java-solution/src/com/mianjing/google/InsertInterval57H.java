package com.mianjing.google;

import com.basicStructure.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/16/19
 * Talk is Cheap,Show me the Code.
 **/
public class InsertInterval57H {
    //don't use new structure to return.
    public List<Interval> insertImprove(List<Interval> list, Interval newIn) {
        int n = list.size();
        int i = 0;
        /// add all the intervals ending before newInterval starts
        while (i < n && list.get(i).end < newIn.start) {
            i++;
        }
        int begin = i;
        // merge all overlapping intervals to one considering newInterval
        while (i < n && newIn.end >= list.get(i).start) {
            newIn.start = Math.min(newIn.start, list.get(i).start);
            newIn.end = Math.max(newIn.end, list.get(i).end);
            i++;
        }

        int end = i-1;
        for(int x = end; x >= begin; x--){
            list.remove(x);
        }
        // add the union of intervals we got
        list.add(begin,newIn);
        return list;

    }

    public List<Interval> insert(List<Interval> list, Interval newIn) {
        int n = list.size();
        List<Interval> ans = new LinkedList<>();
        int i = 0;
        /// add all the intervals ending before newInterval starts
        while (i < n && list.get(i).end < newIn.start) {
            ans.add(list.get(i));
            i++;
        }
        // merge all overlapping intervals to one considering newInterval
        while (i < n && newIn.end >= list.get(i).start) {
            newIn.start = Math.min(newIn.start, list.get(i).start);
            newIn.end = Math.max(newIn.end, list.get(i).end);
            i++;
        }
        // add the union of intervals we got
        ans.add(newIn);
        // add all the rest
        while (i < n) {
            ans.add(list.get(i++));
        }
        return ans;

    }

    public static void main(String[] args){
        InsertInterval57H t = new InsertInterval57H();
        List<Interval> list = new LinkedList<>();
        list.add(new Interval(0,2));
        t.insertImprove(list,new Interval(3,4));
        for(Interval i : list){
            System.out.print("["+i.start+","+i.end+"]\t");
        }
    }
}
