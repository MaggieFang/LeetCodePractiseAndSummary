package com.google;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 12/31/18
 * Talk is Cheap,Show me the Code.
 **/
public class IslandPerimeter463E {
    /**
     * loop over the matrix and count the number of 1;
     * if the current dot is an 1, count if it has any right neighbour or down neighbour;
     * the result is islands * 4 - neighbours * 2
     * 本来应该每个1是4个边，当他有right时候，最后会少了他一条边，对应都跟她公用的另个1就是少了left，所以最后islands * 4 - neighbours * 2
     **/
    public int islandPerimeter(int[][] grid) {
        int cnt = 0, neighbor = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    cnt++;
                    if (j < grid[0].length - 1 && grid[i][j + 1] == 1) neighbor++; //right
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) neighbor++;// down
                }
            }
        }
        return cnt * 4 - neighbor * 2;
    }

    public int islandPerimeter2(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) continue;
                // up
                if (i == 0) {
                    ans++;
                } else if (grid[i - 1][j] == 0) {
                    ans++;
                }

                //down
                if (i == grid.length - 1) {
                    ans++;
                } else if (grid[i + 1][j] == 0) {
                    ans++;
                }

                // left
                if (j == 0) {
                    ans++;
                } else if (grid[i][j - 1] == 0) {
                    ans++;
                }

                //right
                if (j == grid[0].length - 1) {
                    ans++;
                } else if (grid[i][j + 1] == 0) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
