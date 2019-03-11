package com.mianjing.kuola;

import java.util.TreeSet;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-02-20
 * Talk is cheap,show me the Code.
 **/
public class ExamRoom855MSite {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     *Intuition
     *
     * We'll maintain ExamRoom.students, a sorted list (or TreeSet in Java) of positions the students are currently seated in.
     *
     * The ExamRoom.leave(p) operation is clear - we will just list.remove (or TreeSet.remove) the student from ExamRoom.students.
     *
     * Let's focus on the ExamRoom.seat() : int operation. For each pair of adjacent students i and j,
     * the maximum distance to the closest student is d = (j - i) / 2, achieved in the left-most seat i + d.
     * Otherwise, we could also sit in the left-most seat, or the right-most seat.
     * Finally, we should handle the case when there are no students separately.
     * </p>
     * TIME COMPLEXITY:  O(D) for seat,D is the number of students in set. O(log(D)) for leave.
     * SPACE COMPLEXITY: O(N)
     * </p>
     **/

    class ExamRoom {
        private TreeSet<Integer> set;
        private int n;

        public ExamRoom(int N) {
            this.set = new TreeSet<>();
            this.n = N;
        }

        public int seat() {
            if (set.size() == 0) {
                set.add(0);
                return 0;
            }
            int stu = 0;
            int dis = set.first();
            Integer pre = null;
            for (Integer s : set) {
                if (pre != null) {
                    int d = (s - pre) / 2;
                    if (d > dis) {
                        stu = pre + d;
                        dis = d;
                    }

                }
                pre = s;

            }

            if (n - 1 - set.last() > dis) {
                stu = n - 1;
            }

            set.add(stu);
            return stu;


        }

        public void leave(int p) {
            set.remove(p);
        }
    }
}
