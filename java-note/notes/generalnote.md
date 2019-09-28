## HashMap, LinkedHashMap, TreeMap
```java
- firstKey() // 返回集合中第一个元素
- lastKey() // 
- Map.Entry<K,V> lowerEntry(K key); // 返回 < key的第一个元素
- Map.Entry<K,V> floorEntry(K key) // <= key的第一个元素
- K lowerKey(K key);
- K floorKey(K key)
- Map.Entry<K,V> higherEntry(K key); // > key的第一个元素
- Map.Entry<K,V> ceilingEntry(K key);// >= key第一个元素
- K higherkey(K key);// 
- K ceilingKey(K key); // >= key的第一个key
- Map.Entry<K,V> firstEntry(); 
- Map.Entry<K,V> lastEntry();
- Map.Entry<K,V> pollFirstEntry(); //删除并返回第一个元素
- Map.Entry<K,V> pollLastEntry(); //删除并返回最后一个元素
- NavigableMap<K,V> descendingMap();
- NavigableSet<K> descendingKeySet();
- NavigableMap<K,V> subMap(K fromKey, boolean fromInclusive,
                                       K toKey, boolean toInclusive);
- NavigableMap<K,V> headMap(K toKey, boolean inclusive); // 从头到 tokey 的集合
- NavigableMap<K,V> tailMap(K fromKey, boolean inclusive);// 从from到尾的呵呵
- SortedMap<K,V>  headMap(K tokey) //  从头到 tokey(exclude)的集合
- SortedMap<K,V>  tailMap(K fromkey)  // 从fromkey(include)到尾的集合
```

