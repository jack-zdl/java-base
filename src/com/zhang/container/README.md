##  数组和链表 array list
```
数组创建就固定了长度，不能改变长度，但是连接长度可以改变，可以动态增加节点数据。
所以数组查询比较方便，链表的修改比较方便。
```
		2.1ConcurrentHashMap的锁分段技术 
		2.2ConcurrentHashMap的读是否要加锁，为什么 
		2.3ConcurrentHashMap的迭代器是强一致性的迭代器还是弱一致性的迭代器 
		2.4HashMap和HashTable的区别：
		    HashMap是线程不安全的，并且可以接受null值作为他的key和value。
## HashMap
```
    **基于哈希表的Map接口实现**
    3.1 实现了Map接口的key-value集合，可以允许key和value为null.
    3.2 非线程安全的map，可以使用Iterator来做线程安全。
    3.3 继承AbstractMap，这个类实现了大部分的Map的方法，避免了继承Map的类都要实现的方法的繁琐。
    AbstractMap是 HashMap, TreeMap, ConcurrentHashMap 等类的父类。
        只有一个抽象方法 abstract Set<Entry<K,V>> entrySet();
        为什么继承AbstractMap，还要继承Map接口。为了Class类的getInterfaces这个方法的确不能获取到父类实现的接口，
        如果不写上实现Map接口，这个方法返回的数组中就没有Map.class。
        真实的答案是一个误会而已。
        链接https://stackoverflow.com/questions/2165204/why-does-linkedhashsete-extend-hashsete-and-implement-sete
           AbstractMap的
              size()方法来测量他的长度。
              isEmpty()是否为空
              containsValue()是否包含value的
        Cloneable接口，实现了复制的功能。可以使用clone方法。
    3.4 默认容量static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; 意思是二进制向左移动4位。2^4 = 16
        最大容量2^30.
    3.5 在某种情况下，map结构会转变为树形结构。
    3.6 构造方法 1 HashMap(int initialCapacity, float loadFactor)initialCapacity(初始化容量)，loadFactor(加载因子)
         HashMap(int initialCapacity)传递初始化容量，HashMap()按照初始化创建。
         HashMap(Map<? extends K, ? extends V> m) 传入一个Map集合
         加载因子是表示Hsah表中元素的填满的程度。加载因子越大,填满的元素越多,空间利用率越高，但冲突的机会加大了。
         反之,加载因子越小,填满的元素越少,冲突的机会减小,但空间浪费多了。冲突的机会越大,则查找的成本越高。反之,查找的成本越小。
         因此,必须在 "冲突的机会"与"空间利用率"之间寻找一种平衡与折衷。
         ，HashMap 提供了自动扩容机制，当元素个数达到数组大小 loadFactor 后会扩大数组的大小，
         在默认情况下，数组大小为16，loadFactor 为0.75，也就是说当 HashMap 中的元素超过16\0.75=12时，
         会把数组大小扩展为2*16=32，并且重新计算每个元素在新数组中的位置。

```