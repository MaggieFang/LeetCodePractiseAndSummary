package com.mianjing.fb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/16/18
 * Talk is Cheap,Show me the Code.
 **/
public class GroupAngrams49M {
    /**
     * KEYPOINTS:
     * <p>
     * <p>
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY: O(NKlogK), where N is the length of strs, and K is the maximum length of a string in strs.
     * The outer loop has complexity O(N)as we iterate through each string.
     * Then, we sort each string in O(K \log K)O(KlogK) time.
     * <p>
     * Space Complexity: O(NK), the total information content stored in ans.
     * <p>
     * SPACE COMPLEXITY:
     * <p>
     **/
    public static void main(String[] a) {
        GroupAngrams49M test = new GroupAngrams49M();
        String[] s = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        test.groupAnagrams2(s);
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList();
        }

        HashMap<String, List<String>> ans = new HashMap<>();
        for (String s : strs) {
            //要对一个String内部做排序，需要先转为char[] 再Arrays.sort，在用 String.valueOf(char[]）拿到排序后的String
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca); //不能用toString,不然ans.get(key)一直都会get不到，String地址不同
            List<String> list = ans.getOrDefault(key, new ArrayList<String>());
            list.add(s);
            ans.put(key, list);

        }
        return new ArrayList(ans.values());

    }


    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        List<HashMap<Character, Integer>> map = new ArrayList<>();
        for (String s : strs) {
            int i = checkExist(map, s);
            if (i == -1) {
                List<String> item = new ArrayList<>();
                item.add(s);
                ans.add(item);
                map.add(getUniqueMap(s));

            } else {
                ans.get(i).add(s);
            }
        }
        return ans;
    }

    public HashMap<Character, Integer> getUniqueMap(String s) {
        HashMap<Character, Integer> cur = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int v = cur.getOrDefault(s.charAt(i), 0);
            cur.put(s.charAt(i), v + 1);
        }
        return cur;
    }

    public int checkExist(List<HashMap<Character, Integer>> map, String s) {
        int ans = -1;

        boolean found = true;
        HashMap<Character, Integer> cur = getUniqueMap(s);

        for (int i = 0; i < map.size(); i++) {
            HashMap<Character, Integer> item = map.get(i);
            if (item.size() != cur.size()) {
                continue;
            }
            found = true;
            for (Map.Entry<Character, Integer> entry : item.entrySet()) {
                if (entry.getValue() != cur.get(entry.getKey())) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return i;
            }
        }
        return -1;
    }
}
