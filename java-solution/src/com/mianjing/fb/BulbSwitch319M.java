package com.mianjing.fb;

import java.util.Arrays;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/16/18
 * Talk is Cheap,Show me the Code.
 **/
public class BulbSwitch319M {
    /**
     * KEYPOINTS:
     * <p>
     * 大概意思是，一个灯泡最后要亮着，那他是被操作奇数次，所以要在[1,n]里头找哪些灯泡被执行了奇数次操作
     * 对于一个非平方数来说（比如12），因为有成对的补数（1vs12; 2vs6），所以总是会按下2的倍数次
     * 但是对于一个平方数来说（比如36），因为其中有个数(6)它的补数是自己，所以会按被下奇数次
     * 然后这道题就变成了找[1,n]中间有几个平方数了
     * A bulb ends up on iff it is switched an odd number of times.
     * Call them bulb 1 to bulb n. Bulb i is switched in round d if and only if d divides i.
     * So bulb i ends up on if and only if it has an odd number of divisors.
     * Divisors come in pairs, like i=12 has divisors 1 and 12, 2 and 6, and 3 and 4.
     * Except when i is a square, like 36 has divisors 1 and 36, 2 and 18, 3 and 12, 4 and 9,
     * and double divisor 6. So bulb i ends up on if and only if i is a square.
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
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }

    public int bulbSwitchTimeExceed(int n) {
        boolean[] ans = new boolean[n];
        Arrays.fill(ans, true);
        for (int i = 2; i <= n; i++) {
            int j = 1;
            while (true) {
                int tmp = j * i - 1;
                if (tmp >= n) {
                    break;
                } else {
                    ans[tmp] = !ans[tmp];
                }
                j++;
            }
        }
        int sum = 0;
        for (boolean b : ans) {
            if (b) sum++;
        }
        return sum;
    }
}
