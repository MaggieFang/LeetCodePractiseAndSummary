# 1. basic knowleage

-  [官方文档](https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html)

官方描述：

> Hash table based **implementation of the Map interface**. This implementation provides all of the optional map operations, and permits null values and the null key. (The HashMap class is roughly equivalent to Hashtable, except that it is **unsynchronized**and **permits nulls**.) This class makes no guarantees as to the order of the map; in particular, it does not guarantee that the order will remain constant over time.

### 1.1 basic keywords:

实现map接口，基本等同于Hastable，只是hashmap是非同步的，允许null的key，value，不保证order。e.g：

![mapNoorder](https://github.com/MaggieFang/leetcode/blob/master/java-knowlege/img/mapNoorder.png)

- since it is not synchronized, If multiple threads access a hash map concurrently, and at least one of the threads modifies the map structurally, it *must* be synchronized.e.g

- ```
     Map m = Collections.synchronizedMap(new HashMap(...));
  ```

### 1.2 Performance

- **parameters that affected its performance**:  *initial capacity*and *load factor*. The **capacity** is the number of buckets in the hash table, and the initial capacity is simply the capacity at the time the hash table is created. The **load factor** is a measure of how full the hash table is allowed to get before its capacity is automatically increased. When the number of entries in the hash table exceeds the product of the load factor and the current capacity, the hash table is *rehashed* (that is, internal data structures are rebuilt) so that the hash table has approximately twice the number of buckets

- This implementation provides constant-time performance for the basic operations (`get` and `put`). it's very important not to set the initial capacity too high (or the load factor too low) if iteration performance is important.

  影响性能的两个重要参数，容量(Capacity)和负载因子(Load factor)，不要把`capacity`设置过大，也不要把`load factor`设置过小。当bucket填充的数目（即hashmap中元素的个数）大于`capacity*load factor`时就需要调整buckets的数目为当前的2倍。

# 2. Some Source Implementation

###   2.1 put

1. 对key做hash，然后计算index;
2. 如果没碰撞直接放到bucket；
3. 如果碰撞了，以链表形式存在buckets；如果碰撞导致链表过长，链表转换成红黑树；
4. 如果bucket满了(超过load factor*current capacity)，就要resize。

- Note: 3中转为红黑树是java8后基于性能考虑，java8前全用链表存放

### 2.2 get

1. 根据key计算hash，index；

2. bucket第一个节点命中的话直接返回；有冲突，通过key.equals 查找，若链表，查找性能O（n），树O（lgn）
