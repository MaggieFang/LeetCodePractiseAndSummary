package com.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/14/19
 * Talk is Cheap,Show me the Code.
 **/
public class NumberofIslandsII305H {

    /**
     * Clarification:
     * first,we can use the count island,when a new land added.we dfs the whole grid to count the number of island
     * this will be O(k*m*n) , k size of positions.
     * <p>
     * but for each new pos. we just need to check its neibour to see whether need to increase the count or not.
     * one case is it can be included in a existing one. another case it may decrease the count around it because it connect two prior distinct islands
     * e.g  [1  new  1] the new one in pos{0,1} can connect pos{0,0}, pos{0,2} at the same time,
     * so we can use a map,key is the addland position and value is island_id(indicate which island the position belong to) for the second case.
     * (其实就是union find的思想，只是root用island_id)
     * when a new addland,we check whether its four neighbour are in the map. if so, find their ids(put in a set for unique )
     * and the ids in the set should change to the same id.
     * then you can keep the keys(postions) or iterate the map to find the island_id in the map and change them to the same id
     * *
     * </p>
     * Keypoints:
     *
     * </p>
     * TIME COMPLEXITY:
     * SPACE COMPLEXITY:
     * </p>
     **/

    private final static int CONT = 401;

    public List<Integer> numIslands(int m, int n, int[][] positions) {
        int[][] dir = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}, {0, 0}};//add {0,0} is because the new tests includes duplicates.pos={{0,0},{0,1},{1,2},{1,2}}
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();//放结果的
        int identifier = 0;
        for (int[] pos : positions) {
            HashSet<Integer> values = new HashSet<>();
            HashSet<Integer> keys = new HashSet<>();
            for (int[] d : dir) {
                int x = pos[0] + d[0];
                int y = pos[1] + d[1];
                int key = x * CONT + y;
                if (x >= 0 && y >= 0 && x < m && y < n && map.containsKey(key)) {
                    keys.add(key);
                    values.add(map.get(key));
                }
            }
            int preNum = list.size() == 0 ? 0 : list.get(list.size() - 1);

            if (values.size() == 0) {
                map.put(pos[0] * CONT + pos[1], identifier++);
                list.add(preNum + 1);
            } else {
                int newId = values.iterator().next();
                map.put(pos[0] * CONT + pos[1], newId);
                for (int key : keys) {
                    map.put(key, newId);
                }
                list.add(preNum - values.size() + 1);
            }
        }
        return list;

    }

    /**
     * KEYPOINTS:
     * <p>
     * first,we can use the count island,when a new land added.we dfs the whole grid to count the number of island
     * this will be O(k*m*n) , k size of positions.
     * <p>
     * secord solutition. we can use a map,key is the addland position and value is island_id(indicate which island the position belong to).
     * when a new addland,we check whether its four neighbour are in the map. if so, find their ids(put in a set for unique)
     * and the ids in the set should change to the same id.so iterate the map to find the island_id in the map and change them to the same id
     *
     * </p>
     * TIME COMPLEXITY:
     * <p>
     * SPACE COMPLEXITY:
     * <p>
     **/
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[][] dir = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        if (positions == null || positions.length == 0) return list;
        int id = 0;
        int num = 0;
        for (int[] pos : positions) {
            HashSet<Integer> overlap = new HashSet<>();
            for (int[] d : dir) {
                int x = pos[0] + d[0];
                int y = pos[1] + d[1];
                int key = x * 4001 + y;
                if (x >= 0 && y >= 0 && x < m && y < n && map.containsKey(key)) {
                    overlap.add(map.get(key));
                }
            }

            if (overlap.isEmpty()) {
                num++;
                map.put(pos[0] * 4001 + pos[1], id++);
            } else if (overlap.size() == 1) {
                map.put(pos[0] * 4001 + pos[1], overlap.iterator().next());
            } else {
                int uId = overlap.iterator().next();
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    int k = entry.getKey();
                    int v = entry.getValue();
                    if (overlap.contains(v)) {
                        map.put(k, uId);
                    }
                }
                map.put(pos[0] * 4001 + pos[1], uId);
                num -= (overlap.size() - 1);
            }
            list.add(num);
        }

        return list;
    }
}
