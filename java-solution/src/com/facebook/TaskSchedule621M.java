package com.facebook;


import java.util.Arrays;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/6/18
 * Talk is Cheap,Show me the Code.
 **/
public class TaskSchedule621M {
    /**
     * KEYPOINTS:
     * <p>
     * count the task frequency.
     * for the max one, we create (max-1) chunks for it. and the last one max task put seperately at last.
     * e.g max = 4, A...|A...|A...|A, each chunkd should at last left n space for cooling.
     * so the time the at least will be (max -1)*(n+1)+1
     * and space left after fill the max one will be space = n*(max- 1);
     * the total task left left = task - max
     * so if left <= space. we can put them sepately in the space left.
     * and if left > space, we fill the chunks first, and then expand each chunk to sperately put the (left - space) element.
     *
     * Another thing we follow up it maybe there are same task with same max frequency. so we can consider into one bunch.
     * e.g if the A and B are with the same max frenquecy 4.
     * then we get AB..|AB..|AB..|AB, and the above formula that consider maxCount(2 in this case) instead of 1
     * the least we need is least = (maxF - 1)(n+1)+ maxCount;
     * the space left = least - maxCount*maxF;
     * the task left = task - maxCount * maxF;
     *
     * Another thing is when the number of same maxF  > n
     * So least we need is maxF * maxCount
     * and the space left = 0;
     * the task left = task - maxF * maxCount;
     *
     *
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
    public int leastInterval(char[] task, int n) {
        int[] c = new int[26];
        for (char item : task) {
            c[item - 'A']++;
        }
        Arrays.sort(c);

        // to count the number with the same size of max frequency.
        int maxCount = 1;
        int i = 24;
        while (i >= 0 && c[25] == c[i]) {
            --i;
            maxCount++;
        }

        int least;
        int spaceLeft;


        if (n >= maxCount) {
            least = (c[25] - 1) * (n + 1) + maxCount;
            spaceLeft =  least - maxCount* c[25];
        } else {
            least = c[25]*maxCount;
            spaceLeft = 0;
        }

        int left = task.length - c[25] * maxCount;
        int result = least;
        if (left > spaceLeft) {
            result = least + (left - spaceLeft);
        }
        return result;
    }

    public static void main(String[] args) {
        char[] task = new char[]{'A', 'A', 'A', 'B', 'B', 'B'};
        TaskSchedule621M test = new TaskSchedule621M();
        System.out.println(test.leastInterval(task, 2));

    }
}
