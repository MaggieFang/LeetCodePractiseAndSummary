package com.mock;

import java.util.HashMap;
import java.util.Map;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/17/18
 * Talk is Cheap,Show me the Code.
 **/
public class DictFlatten {
    static HashMap<String, String> flattenDictionary(HashMap<String, Object> dict) {
        // your code goes here
        HashMap<String,String> ans = new HashMap<>();

        if(dict == null){
            return ans;
        }
        flatten(dict,"",ans);
        return ans;
    }

    static void flatten(HashMap<String,Object> dict,String keyPre,HashMap<String,String> ans){
        if(dict == null){
            return;
        }

        for(Map.Entry<String,Object> entry : dict.entrySet()){
            String k= entry.getKey();
            Object v = entry.getValue();
            if(v instanceof String){
                if(keyPre == "" || keyPre == null){
                    ans.put(k,v.toString());
                }else{
                    ans.put(keyPre+"."+k,v.toString());
                }

            }else{
                if(keyPre == "" || keyPre == null){
                    flatten((HashMap<String, Object>) v,k,ans);
                }else{
                    flatten((HashMap<String, Object>) v,keyPre+"."+k,ans);

                }
            }
        }

    }

    public static void main(String[] a){
        HashMap<String,Object> dict = new HashMap<>();
        HashMap<String,String> item = new HashMap<>();
        item.put("a","1");
        dict.put("",item);
        dict.put("b","3");
        System.out.println(flattenDictionary(dict));
//        {
//                "Key1" : "1",
//                "Key2" : {
//            "a" : "2",
//                    "b" : "3",
//                    "c" : {
//                "d" : "3",
//                        "e" : {
//                    "" : "1"
//                }
//            }
//        }
    }

}
