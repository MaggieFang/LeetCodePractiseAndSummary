package com.mianjing.google;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

import sun.nio.cs.ext.MacHebrew;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/16/19
 * Talk is Cheap,Show me the Code.
 **/
public class RangeModule715H {
    class RangeModule {
        TreeSet<int[]> set;
        public RangeModule() {
            set = new TreeSet<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });

        }

        public void addRange(int left, int right) {
            int i = 0;
            int n = set.size();
            Iterator<int[]> it = set.iterator();
            int[] begin = null;
            while (it.hasNext()){
                int[] tmp = it.next();
                if(tmp[1] < left){
                    continue;
                }else {
                    left = Math.min(tmp[0],left);
                    right = Math.max(tmp[1],right);
                    begin = tmp;
                    break;
                }
            }
            int[] end= null;
           while (it.hasNext()){
                int[] tmp = it.next();
                if(tmp[0] <= right){
                    left = Math.min(tmp[0],left);
                    right = Math.max(tmp[1],right);
                    end = tmp;
                    continue;
                }else {
                   break;
                }
           }

           set.removeAll(set.subSet(begin,true,end,true));
           set.add(new int[]{left,right});
        }

//        public boolean queryRange(int left, int right) {
//
//        }
//
//        public void removeRange(int left, int right) {
//
//        }
    }
}
