package com.test;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-02-01
 * Talk is Cheap,Show me the Code.
 **/
public class MyHashMap {
    private static final int SIZE = 16;
    public Entry[] entries = new Entry[SIZE];

    private int getBucket(int hash) {
        return hash & (SIZE - 1);
    }

    //https://www.zhihu.com/question/20733617
    private int hash(Object key) {
        if (key == null) return 0;

        int h = key.hashCode();
        h = h ^ (h >>> 16);
        return h;
    }

    public void put(String key, String value) {
        int index = 0;
        if (key != null) {
            int hash = hash(key);
            index = getBucket(hash);
        }

        Entry cur = entries[index];
        while (cur != null) {
            if (cur.key.equals(key)) {
                cur.value = value;
                return;
            }
            cur = cur.next;
        }
        Entry newOne = new Entry(key, value);
        newOne.next = entries[index];
        entries[index] = newOne;
    }

    public String get(String key) {
        int hash = hash(key);
        int bucket = getBucket(hash);
        Entry cur = entries[bucket];
        while (cur != null) {
            if (cur.key.equals(key)) {
                return cur.value;
            }
            cur = cur.next;
        }
        return null;

    }


    class Entry {
        String key;
        String value;
        Entry next;

        public Entry(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put("a", "a1");
        map.put("m", "m1");
        map.put("k", "k1");
        map.put("a", "a2");
        System.out.println(map.get("a"));
        System.out.println(map.get("z"));
        System.out.println(map.get("k"));
    }


}
