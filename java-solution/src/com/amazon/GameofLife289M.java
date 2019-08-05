package com.amazon;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-08-05
 **/
public class GameofLife289M {
    /**
     * Clarification:
     * we use the original data for update? Yes
     * </p>
     * Keypoints:
     * The overall is a two loop for each element, and check the 8 directions to count the number of '1' to decide should we change the status of current one.
     * but we need to use original data for update. so how ? we can use some new value to indicate the element were change.
     * e.g from 1 to 0 using new value -1, from 0 to 1 using new value 2.
     * and finally update the board's -1 and 2 to 0 and 1 perspectively.
     * As for 8 directions, we can use dx and dy array for easy access
     * </p>
     * TIME COMPLEXITY: O(mn)
     * SPACE COMPLEXITY:O(1)
     * </p>
     **/
    public void gameOfLife(int[][] board) {
        int[] dx = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
        int[] dy = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cnt = 0;
                for (int k = 0; k < 8; k++) {
                    int x = i + dx[k];
                    int y = j + dy[k];
                    if (x >= 0 && y >= 0 && x < m && y < n && (board[x][y] == 1 || board[x][y] == -1)) {//don't forget  board[x][y] == -1 which are changed from live to dead
                        cnt++;
                    }
                }

                if (board[i][j] == 1 && (cnt < 2 || cnt > 3)) {
                    board[i][j] = -1;
                } else if (board[i][j] == 0 && cnt == 3) {
                    board[i][j] = 2;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == -1) board[i][j] = 0;
                else if (board[i][j] == 2) board[i][j] = 1;
            }
        }

    }
}
