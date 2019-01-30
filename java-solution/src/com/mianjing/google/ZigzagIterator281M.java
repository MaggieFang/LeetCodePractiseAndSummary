package com.mianjing.google;

import java.util.Iterator;
import java.util.List;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/10/19
 * Talk is Cheap,Show me the Code.
 **/
public class ZigzagIterator281M {

    public class ZigzagIterator {
        List<Integer> v1;
        List<Integer> v2;
        int p1 = 0;
        int p2 = 0;
        boolean first = true;

        public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
            v1.iterator();
            this.v1 = v1;
            this.v2 = v2;
        }

        public int next() {
            if (first && p1 < v1.size()) {
                if (p2 < v2.size()) { // [1,2][]
                    first = false;
                }
                return v1.get(p1++);
            }

            if (p2 < v2.size()) {
                first = true;
                return v2.get(p2++);
            }
            return Integer.MIN_VALUE;

        }

        public boolean hasNext() {
            return p1 < v1.size() || p2 < v2.size();

        }
    }

    public class ZigzagIterator2 {

        Iterator<Integer> i, j, tmp;

        public ZigzagIterator2(List<Integer> v1, List<Integer> v2) {
            this.i = v2.iterator();
            this.j = v1.iterator();
        }

        public int next() {
            if (j.hasNext()) {
                tmp = i;
                i = j;
                j = tmp;
            }
            return i.next();

        }

        public boolean hasNext() {
            return i.hasNext() || j.hasNext();
        }
    }
}
