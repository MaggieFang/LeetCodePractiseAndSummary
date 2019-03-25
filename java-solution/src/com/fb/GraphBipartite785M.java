package com.fb;

import java.util.Arrays;
import java.util.Stack;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/9/18
 * Talk is Cheap,Show me the Code.
 **/
public class GraphBipartite785M {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color,-1);
        for(int i = 0; i < n; i++){
            if(color[i] == -1){
                Stack<Integer> stack = new Stack<>();
                stack.push(i);
                color[i] = 0;
                while (!stack.isEmpty()){
                    int cur = stack.pop();
                    for(int j = 0 ; j < graph[cur].length; j++){
                        int next = graph[cur][j];
                        if(color[next] == -1){
                            stack.push(next);
                            color[next] = color[cur]^1;
                        }else if(color[next] == color[cur]){
                            return false;
                        }

                    }
                }
            }
        }
        return true;
    }
}
