## 1. Why Collection 

Before Collection Framework was introduced, the standard methods for grouping Java objects were Arrays or Vectors or Hashtables. All of these collections had no common interface.Accessing elements of these Data Structures was a hassle as each had a different method

**Java developers decided to come up with a common interface to deal with the above mentioned problems and introduced the Collection Framework in JDK 1.2**.

**Advantages of Collection Framework:**

1. **Consistent API** : The API has a basic set of interfaces like Collection, Set, List, or Map. All classes (ArrayList, LinkedList, Vector, etc) that implement these interfaces have *some* common set of methods.

2. **Reduces programming effort**: A programmer doesn’t have to worry about the design of Collection, and he can focus on its best use in his program.

3. **Increases program speed and quality**: Increases performance by providing high-performance implementations of useful data structures and algorithms.

   统一的api，都有一套共同的方法；对开发者更友好；性能更好；

## 2. Collection & Map

The Collection interface (**java.util.Collection**) and Map interface (**java.util.Map**) are the two main “root” interfaces of Java collection classes.

Java 集合框架主要包括两种类型的容器，一种是集合（Collection），存储一个元素集合，另一种是图（Map），存储键/值对映射。Collection 接口又有 3 种子类型，List、Set 和 Queue，再下面是一些抽象类，最后是具体实现类，常用的有 ArrayList、LinkedList、HashSet、LinkedHashSet，Map中有haspmap等。

```
             Collection                  Map
         /       /    \    \              |  \
        /       /      \     \            |   \
     Set     List    Queue  Dequeue   HashMap SortedMap
     /   \
    /     \
SortedSet HasSet
    |       |
    |       |
TreeSet    LinkedHashSet
```

## 3. How to distinguish them

There are so many subinterface & implementation of Collections of Map.  I think when someone ask the difference between them. Maybe the basic answer can be from  【**Order** or not? **Permit Null** Key/Value?    Permit **Duplicate**? **Synchronization**? **Performance** of add,remove,contain etc. 】perspectives.

问各个类之间的区别感觉可以从 是否有序(order), 是否允许null key/value? 元素是否可以重复？是否是线程安全、同步的？性能这五方面，再佐以场景例子。

## 4. List and its sub

List: An ordered collection (also known as a *sequence*). The user of this interface has precise control over where in the list each element is inserted. The user can access elements by their integer index (position in the list), and search for elements in the list.

Unlike sets, lists typically allow duplicate elements. More formally, lists typically allow pairs of elements `e1` and `e2` such that `e1.equals(e2)`, and they typically allow multiple null elements if they allow null elements at all.

| Class                                                        | Duplicate | Permit Null    | Oder | Synchronization | Performance                                                  |
| ------------------------------------------------------------ | --------- | -------------- | ---- | --------------- | ------------------------------------------------------------ |
| List                                                         | √         | Depends on sub |      |                 |                                                              |
| ArrayList. (roughly equivalent to `Vector`, except that it is unsynchronized) | √         | √              |      | ❌               | The `size`, `isEmpty`, `get`, `set`, `iterator`, and `listIterator` operations run in constant time. The `add` operation runs in *amortized constant time*, that is, adding n elements requires O(n) time. All of the other operations run in linear time (roughly speaking). The constant factor is low compared to that for the `LinkedList` implementation |

```
 List list = Collections.synchronizedList(new ArrayList(...));
```

## 5. Set and its Sub

Set: A collection that contains no duplicate elements. More formally, sets contain no pair of elements `e1` and `e2` such that `e1.equals(e2)`, and at most one null element. 

| Class   | Duplicate | Permit null | Order                                                        | Synchronization | Performance                                                  |
| ------- | --------- | ----------- | ------------------------------------------------------------ | --------------- | ------------------------------------------------------------ |
| Set     | ❌         | √ at most 1 |                                                              |                 |                                                              |
| HashSet | ❌         | √           | ❌                                                            | ❌               | constant time performance for `add`, `remove`, `contains` and `size` |
| TreeSet | ❌         | √           | √ by natural order or by a [`Comparator`](https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html) | ❌               | log(n) time cost for the basic operations (`add`, `remove` and `contains`). |

```
Set s= Collections.synchronizedSet(new HashSet(...));
Collections.synchronizedSortedSet(new TreeSet(...));
```

## 6. Map and its sub

The `Map` interface provides three *collection views*, which allow a map's contents to be viewed as a set of keys, collection of values, or set of key-value mappings. The *order* of a map is defined as the order in which the iterators on the map's collection views return their elements. Some map implementations, like the `TreeMap` class, make specific guarantees as to their order; others, like the `HashMap` class, do not. 

Map & Set & List: 关于Map，我们要从代码复用的角度去理解，java是先实现了Map，然后通过包装了一个所有value都为null的Map就实现了Set集合;

Map的这些实现类和子接口中key集的存储形式和Set集合完全相同(即key不能重复);
Map的这些实现类和子接口中value集的存储形式和List非常类似(即value可以重复、根据索引来查找)
![HashSetFromHashMap](https://github.com/MaggieFang/leetcode/blob/master/java-knowlege/img/HasSetFromHashMap.png)

Note: more about [HashMap](https://github.com/MaggieFang/leetcode/blob/master/java-knowlege/notes/hasmap.md)

| Class                                                        | Duplicate key | Permit Null | Oder | Synchronization | Performance                                                  |
| ------------------------------------------------------------ | ------------- | ----------- | ---- | --------------- | ------------------------------------------------------------ |
| Map                                                          | ❌             |             |      |                 |                                                              |
| HasMap((roughly equivalent to `HashTable`, except that it is unsynchronized) | ❌             | √           | ❌    | ❌               | constant-time performance for the basic operations (`get` and `put`), |

```
 Map m = Collections.synchronizedMap(new HashMap(...));
```

## 7. Reference

https://docs.oracle.com/javase/8/docs/api/java/util/Map.html

https://docs.oracle.com/javase/8/docs/api/java/util/Collection.html

https://www.geeksforgeeks.org/collections-in-java-2/