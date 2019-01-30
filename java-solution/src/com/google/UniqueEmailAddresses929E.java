package com.google;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 12/29/18
 * Talk is Cheap,Show me the Code.
 **/
public class UniqueEmailAddresses929E {
    /**
     1 process the charaters before @. how?
     ignore the '.' and end before"+"
     2 map the domain to local HashMap<String,HashSet>
     **/
    public int numUniqueEmails(String[] emails) {
        HashMap<String,HashSet<String>> map = new HashMap<>();
        for(String s: emails){
            String[] split = s.split("@");
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < split[0].length();i++){
               char c = split[0].charAt(i);
                if(c == '+'){
                    break;
                }
                if(c == '.'){
                    continue;
                }
                sb.append(c);
            }

            HashSet<String> set = map.getOrDefault(split[1],new HashSet<String>());
            set.add(sb.toString());
            map.put(split[1],set);
        }
        int ans = 0;
        for(HashSet<String> set: map.values()){
            ans+= set.size();
        }
        return ans;
    }


}
