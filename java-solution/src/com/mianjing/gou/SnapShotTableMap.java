package com.mianjing.gou;

import java.util.HashMap;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-02-06
 * Talk is cheap,show me the Code.
 **/
public class SnapShotTableMap {

    /***q
     * SnapshottableMap map = new SnapshottableMap();
     * map.put("name", "John");
     * map.put("country", "UK");
     *
     * Snapshot s1 = map.createSnapshot();
     *
     * assert(s1.get("name").equals("John"));
     * assert(s1.get("country").equals("UK"));
     *
     * map.put("name", "Marta");
     * Snapshot s2 = map.createSnapshot();
     *
     * assert(s2.get("name").equals("Marta"));
     * assert(s2.get("country").equals("UK"));
     * assert(s1.get("name").equals("John"));
     *
     * question:
     * if I add a new put("C","MM") after s1 created? s1.get("C") == null?
     * if yes, I think it is a problem to save the current state when create Snapshot. so new a new map to contain all
     * elements at that time point
     */
    public static void main(String[] args){
        SnapShotTableMap map = new SnapShotTableMap();
        map.put("name", "John");
        map.put("country", "UK");
        map.put(null,null);
        map.put("","");
        Snapshot s1 = map.createSnapshot();
        System.out.println(s1.get("name")); //(s1.get("name").equals("John"));
        System.out.println(s1.get("country"));//(s1.get("country").equals("UK"));

        map.put("name", "Marta");
        map.put(null,"0000");
        map.put("","222");

        Snapshot s2 = map.createSnapshot();
        System.out.println(s2.get("name"));//(s2.get("name").equals("Marta"));
        System.out.println(s2.get("country"));//(s2.get("country").equals("UK"));
        System.out.println(s1.get("name")); //(s1.get("name").equals("John"));
        System.out.println(s1.get(null)); //(s1.get("name").equals("John"));
        System.out.println(s2.get(null)); //(s1.get("name").equals("John"));
        System.out.println(s1.get("")); //(s1.get("name").equals("John"));
        System.out.println(s2.get("")); //(s1.get("name").equals("John"));

    }
    private HashMap<String, String> map;

    public SnapShotTableMap() {
        map = new HashMap<>();
    }

    public void put(String key, String value) {
        map.put(key, value);
    }

    public Snapshot createSnapshot() {
        return new Snapshot(this.map);
    }

    class Snapshot {
        private HashMap<String, String> map;

        public Snapshot(HashMap<String, String> map) {
            this.map = new HashMap<>(map);
        }

        public String get(String key) {
            return map.get(key);
        }
    }
}
