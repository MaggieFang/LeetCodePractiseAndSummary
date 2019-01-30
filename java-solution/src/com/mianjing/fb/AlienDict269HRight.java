package com.mianjing.fb;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/19/18
 * Talk is Cheap,Show me the Code.
 **/
public class AlienDict269HRight {
    private static final int N = 26;

    public static String alienOrder(String[] words) {
        boolean[][] adj = new boolean[N][N];
        int[] visited = new int[N];
        buildGraph(words, adj, visited);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (visited[i] == 0) {    // unvisited
                if (!dfs(adj, visited, sb, i)) return "";
            }
        }
        return sb.reverse().toString();
    }

    public static boolean dfs(boolean[][] adj, int[] visited, StringBuilder sb, int i) {
        visited[i] = 1;                            // 1 = visiting
        for (int j = 0; j < N; j++) {
            if (adj[i][j]) {                        // connected
                if (visited[j] == 1) return false;  // 1 => 1, cycle
                if (visited[j] == 0) {              // 0 = unvisited
                    if (!dfs(adj, visited, sb, j)) return false;
                }
            }
        }
        visited[i] = 2;                           // 2 = visited
        sb.append((char) (i + 'a'));
        return true;
    }

    public static void buildGraph(String[] words, boolean[][] adj, int[] visited) {
        Arrays.fill(visited, -1);                 // -1 = not even existed
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                visited[c - 'a'] = 0; //出现的字符
            }
            if (i > 0) {
                String w1 = words[i - 1], w2 = words[i];
                int len = Math.min(w1.length(), w2.length());
                for (int j = 0; j < len; j++) {
                    char c1 = w1.charAt(j), c2 = w2.charAt(j);
                    if (c1 != c2) {
                        adj[c1 - 'a'][c2 - 'a'] = true;
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] a) {
        String[] s = new String[]{"wrt", "wrfjk", "erfg"};
//        String[] s = new String[]{"wrt","wrf","er","ett","rftt"};
//        String[] s = new String[]{"zy","zx"};
        System.out.println(alienOrder(s));

    }
}
