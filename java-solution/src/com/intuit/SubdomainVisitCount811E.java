package com.intuit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-02-04
 * Talk is Cheap,Show me the Code.
 **/
public class SubdomainVisitCount811E {
    public List<String> subdomainVisits(String[] domain) {
        List<String> ans = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : domain) {
            int idx = s.indexOf(" ");
            int  num = Integer.parseInt(s.substring(0,idx));
            String[] sp = s.substring(idx+1).split("\\.");
            StringBuilder sb = new StringBuilder();
            for (int i = sp.length - 1; i >= 0; i--) {
                if (i != sp.length - 1) {
                    sb.insert(0,sp[i]+".");
                } else {
                    sb.insert(0,sp[i]);
                }
                String cur = sb.toString();
                map.put(cur, map.getOrDefault(cur, 0) + num);
            }

        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            ans.add(entry.getValue() + " " + entry.getKey());
        }
        return ans;
    }

    public static void main(String[] args) {
        SubdomainVisitCount811E e = new SubdomainVisitCount811E();
        System.out.println(e.subdomainVisits(
                new String[]{"9001 discuss.leetcode.com"}));
    }
}
