package com.mianjing.google;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/11/19
 * Talk is Cheap,Show me the Code.
 **/
public class GuessNumberHigherorLower374E {
    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int r = guess(mid);
            if (r == 0) {
                return mid;
            } else if (r == 1) {
                low = mid + 1;

            } else {
                high = mid - 1;
            }
        }

        return low;

    }

    private int guess(int mid) {
        if (mid == 6) {
            return 0;
        }
        if (mid > 6) {
            return -1;
        }
        return 1;
    }

}
