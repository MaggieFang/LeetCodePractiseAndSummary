package com.fb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/10/18
 * Talk is Cheap,Show me the Code.
 **/
public class AccountMerge721M {

    public List<List<String>> accountsMergeUnionFind(List<List<String>> accounts) {
        int n = accounts.size();
        int[] root = new int[n];
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < root.length; i++) {
            root[i] = i;
        }

        for (int i = 0; i < n; i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String s = account.get(j);
                if (!map.containsKey(s)) {
                    map.put(s, i);
                }

                int x = findRoot(map.get(account.get(1)), root);
                int y = findRoot(map.get(s), root);
                if (x != y) {
                    root[y] = x;
                }
            }
        }

        HashMap<Integer, List<Integer>> linkIndex = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < root.length; i++) {
            List<Integer> list = linkIndex.getOrDefault(root[i], new ArrayList<Integer>());
            list.add(i);
            linkIndex.put(root[i], list);
        }

        for (Map.Entry<Integer, List<Integer>> entry : linkIndex.entrySet()) {
            Integer key = entry.getKey();
            List<Integer> list = entry.getValue();
            HashSet<String> item = new HashSet<>();

            for (Integer i : list) {
                List<String> aa = accounts.get(i);
                for (int j = 1; j < aa.size(); j++) {
                    item.add(aa.get(j));
                }
            }
            LinkedList fi = new LinkedList<String>(item);
            Collections.sort(fi);
            fi.add(0, accounts.get(key).get(0));
            ans.add(fi);
        }
        return ans;

    }

    public int findRoot(int i, int[] root) {
        if (i != root[i]) {
            root[i] = findRoot(root[i], root);
        }
        return root[i];
    }


    /**
     * KEYPOINTS:
     * <p>
     * If two mails belong to the same account. we can draw a line between.
     * so when we travels some email we have draw.we can also draw the line to connect them.
     * So it is much like a graph relation. the node is the email.
     * So we can build a graph for all the emails.
     * Generally, we build the nodes in two dimensional date structure.such as [[1,2],[0],[0,1]],
     * it means node 0 has edge to node 1,and node 2. the index of A[i] can represent the node.
     * But this question the node is a string.
     * So we need a HashMap to store the relations HashMap<key,List<String>,the key is the cur email.
     * the list is the cur email has edge with them.
     * The next question,is the get the nodes in a component. so depth Travel can be used to search them.
     * So this problem can break into two subproblem. build the email relation with graph. and to do BSF.
     * But when the List<email> we get from BSF,we need to know it belongs to whom.
     * so maybe we need another map to store the relation between mail and name.to get the name from the mail.
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
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, Set<String>> graph = new HashMap<>();// build relation between emails.
        HashMap<String, String> mapNames = new HashMap<>(); // map email->name;
        for (List<String> list : accounts) {
            String name = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                String mail = list.get(i);
                if (!graph.containsKey(mail)) {
                    graph.put(mail, new HashSet<String>()); //set instead of list to avoid duplicate
                }
                mapNames.put(mail, name);
                if (i == 1) continue;
                graph.get(mail).add(list.get(i - 1));
                graph.get(list.get(i - 1)).add(list.get(i));

            }
        }
        //done build the relation email graph

//        boolean[] visited = new boolean[graph.size()];
        Set<String> visited = new HashSet<>();
        for (Map.Entry<String, Set<String>> entry : graph.entrySet()) {
            String key = entry.getKey();
            if (!visited.contains(key)) {
                ArrayList<String> item = new ArrayList<>();
                item.add(mapNames.get(key));
                result.add(item); // donot forget to add to the result; we just updat item in DFS.
                visited.add(key);

                DFSHelper(visited, key, entry.getValue(), item);
                Collections.sort(item);
            }

        }

        return result;

    }

    List<List<String>> result = new ArrayList<>();

    public void DFSHelper(Set<String> visited, String cur, Set<String> relation, List<String> item) {
        item.add(cur);
        for (String s : relation) {
            if (!visited.contains(s)) {
                visited.add(s);
                DFSHelper(visited, s, relation, item);
            }
        }
    }

    public static void main(String[] args) {
        AccountMerge721M test = new AccountMerge721M();
        List s1 = Arrays.asList(new String[]{"John", "johnsmith@mail.com", "john_newyork@mail.com"});
        List s2 = Arrays.asList(new String[]{"Mary", "mary@mail.com"});
        List s3 = Arrays.asList(new String[]{"John", "johnnybravo@mail.com"});
        List<List<String>> as = new ArrayList<>();
        as.add(s1);
        as.add(s2);
        as.add(s3);

        System.out.println(test.accountsMergeUnionFind(as));
    }
}
