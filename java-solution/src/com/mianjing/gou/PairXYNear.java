package com.mianjing.gou;

import java.util.LinkedList;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/17/19
 * Talk is Cheap,Show me the Code.
 **/
public class PairXYNear {
    /**
     * Q: just found the nearest or should pair, when Y used,cannot used any more?
     * case 1: cannot access?
     *  [ * * X X
     *    * * X Y
     *    * * X Y ] what about (0,2)X to Y ? Maxvalue?
     *
     *
     *  case 2: tie
     *  [ * * X X
     *    Y * X Y
     *    * * X Y ] what about (0,2)X to Y ? Maxvalue?
     *    for People A , whether exist there are two bikes. A'distance to bike 1 == distance to bike 2
     * **/

    int m;
    int n;
    private final static int[][] DIR = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public void pair(char[][] grid){
        m = grid.length;
        n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
              if(grid[i][j] == 'X'){
                  bfs(grid,i,j);
              }
            }
        }
    }

    public void  bfs(char[][] grid,int i ,int j){
        int step = 0;
        boolean found = false;
        boolean[][] visited = new boolean[m][n];
        LinkedList<Integer> q = new LinkedList<>();
        q.add(i*n+j);
        visited[i][j] = true;
        while (!q.isEmpty()){
            int size = q.size();
            while (size > 0){
                int cur = q.poll();
                size--;
                int curX = cur/n;
                int curY = cur % n;
                for(int[] d:DIR){
                    int x = d[0]+curX;
                    int y = d[1]+curY;
                    if(x >= 0 && y >= 0 && x < m && y < n && !visited[x][y] && grid[x][y] != 'X'){
                        visited[x][y] = true;
                        if(grid[x][y] == 'Y'){
                            System.out.println("X["+i+","+j+"] to Y [ " + x+","+y+"], distance = "+ (step+1));
                            found = true;
                            break;
                        }else if(grid[x][y] == '*'){
                                q.add(x*n+y);

                        }
                    }
                }
                if(found) break;
            }
            if(found) break;
            step++;
        }
        if(!found){
            System.out.println("X["+i+","+j+"] can not access to any Y" );
        }
    }
}
