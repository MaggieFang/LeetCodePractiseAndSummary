package com;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-09-30
 **/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//coursera
class Dict implements DictEntry {
    private Map<String, DictEntry> map;

    public Dict(Map<String, DictEntry> map) {
        this.map = map;
    }

    public boolean isDict() {
        return true;
    }

    public Set<String> getKeys() {
        return map.keySet();
    }

    public DictEntry get(String key) {
        return map.get(key);
    }
}

interface DictEntry {
    public boolean isDict();
}

class StringWrapper implements DictEntry {

    private String str;

    public StringWrapper(String str) {
        this.str = str;
    }

    public boolean isDict() {
        return false;
    }

    public String getValue() {
        return str;
    }
}

public class Solution {
    /*
     * Complete the functions below.
     */

    public static void main(String[] args) {
        Map<String, DictEntry> map = new HashMap<>();
        map.put("a", new StringWrapper("apple"));

        Map<String, DictEntry> sub = new HashMap<>();
        sub.put("b", new StringWrapper("blueberry"));
        sub.put("c", new StringWrapper("cranberry"));
        Dict subDict = new Dict(sub);

        map.put("b", subDict);
        System.out.println(dictionaryToJson(new Dict(map)));
        String s = "{a:apple,b:{b:blueberry,c:cranberry}}";
        String s2 = "{b:{b:blueberry,c:cranberry},c:{m:{n:k}}}";
        String s3 = "{a:apple,b:battle}";

        Dict d1 = jsonToDictionary(s);
        Dict d2 = jsonToDictionary(s2);
        Dict d3 = jsonToDictionary(s3);
        System.out.println();

    }

    static String dictionaryToJson(Dict dictionary) {
        if (dictionary == null) return "";
        StringBuilder sb = new StringBuilder("{");
        Set<String> keysets = dictionary.getKeys();

        for (String key : keysets) {
            if (sb.length() > 1) {
                sb.append(',');
            }
            sb.append(key);
            sb.append(':');
            DictEntry entry = dictionary.get(key);
            if (!entry.isDict()) {
                sb.append(((StringWrapper) entry).getValue());
            } else {
                sb.append(dictionaryToJson((Dict) entry));
            }
        }
        sb.append("}");
        return sb.toString();
    }

    static Dict jsonToDictionary(String json) {
        Stack<Object> stack = new Stack<>();
        int n = json.length();
        for (int i = 0; i < n; i++) {
            char c = json.charAt(i);
            if (c == '{') {
                stack.push("{");
            } else if (Character.isLetter(c)) {
                StringBuilder sb = new StringBuilder();
                sb.append(c);
                i++;
                while (i < json.length() && Character.isLetter(c = json.charAt(i))) {
                    sb.append(c);
                    i++;
                }
                i--;
                stack.push(sb.toString());
            } else if (c == '}') {
                HashMap<String, DictEntry> map = new HashMap<>();
                while (!stack.isEmpty()) {
                    Object o = stack.pop();
                    if ("{".equals(o)) {
                        break;
                    }
                    Object o2 = stack.pop();
                    if (o instanceof Dict) {
                        map.put((String) o2, (Dict) o);
                    } else {
                        map.put((String) o2, new StringWrapper((String) o));
                    }
                }
                stack.push(new Dict(map));
            }
        }
        return (Dict) stack.pop();
    }

}


//{a:apple,b:{b:blueberry,c:cranberry}} //stack
//a:apple b:{b:blueberry c:cranberry}
//
