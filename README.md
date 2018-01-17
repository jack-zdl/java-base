# java-base
主要来写java基础和整合设计模式，
这是一篇自由练习的java学习开源项目，为了让大家更加系统掌握java学习，更快速成长在大牛的道路上，看看你我要学习多少基础的东西。来和我一起学习吧。 基础知识包括：

> 1 基本语法： 

+	1.1static的意义
+	1.2volatile关键字的底层实现原理。等一些基础的知识。 
+	1.3java本身带有的注解
+   1.4final finally finlise的区别
```
		@SuppressWarnings("unchecked")
		告诉编译器忽略 unchecked 警告信息，如使用List，ArrayList等未进行参数化产生的警告信息。
·   	@SuppressWarnings("serial")
		如果编译器出现这样的警告信息：The serializable class WmailCalendar does not declare a 
		static final serialVersionUID field of type long
		使用这个注释将警告信息去掉。
·   	@SuppressWarnings("deprecation")
		如果使用了使用@Deprecated注释的方法，编译器将出现警告信息。
		使用这个注释将警告信息去掉。
·   	@SuppressWarnings("unchecked", "deprecation")
		告诉编译器同时忽略unchecked和deprecation的警告信息。
·   	@SuppressWarnings(value={"unchecked", "deprecation"})
		等同于@SuppressWarnings("unchecked", "deprecation")
```
+	1.4	java中具体执行的代码必须放进代码块中，和方法中
```
		int a  = 5 ;
		{ 
		 a = a + 5;//这是执行代码，不放在代码块中，方法中，类实例化后无法执行。
		}
```
+   1.5 String讲解
```
    1 String是不能被继承的，因为被final修饰，详情查询final的用法。
    2 String有二个属性，private final char[] value; private int hash;
    在初建时,String a = new String();建立一个""空字符串。长度hash默认为0,
    // 程序编译期即加载完成对象s1为"ab"，JVM自有优化， 效率并不差
    String s1 = "a" + "b";  
```

>   2容器：包括一些集合set list map，集合要掌握的是ArrayList、LinkedList、
	Hashtable、HashMap、ConcurrentHashMap、HashSet的实现原理。 
###  数组和链表 array list
```
数组创建就固定了长度，不能改变长度，但是连接长度可以改变，可以动态增加节点数据。
所以数组查询比较方便，链表的修改比较方便。
```
		2.1ConcurrentHashMap的锁分段技术 
		2.2ConcurrentHashMap的读是否要加锁，为什么 
		2.3ConcurrentHashMap的迭代器是强一致性的迭代器还是弱一致性的迭代器 
		2.4HashMap和HashTable的区别：
		    HashMap是线程不安全的，并且可以接受null值作为他的key和value。
### 数据结构和算法
```
数据结构：
	1 线性表 ：数组，链表，队列，栈
	线性表中 底层我们可以实现数组因为list中的arraylist就是一个简答的数组，和链表linkedList
	我们可以基于数组和链表来做成队列和堆栈。
	队列类：实现了Queue接口的类，如LinkedBlockingQueue，LinkedList。
	堆栈类：Stack
		数组：
	2非线性表：树（二叉树），图，表
算法：
	1冒泡排序
	2快速排序
	3插入排序
	等等很多排序算法
```		
		
>   3设计模式：23中设计模式。
 
		3.1工厂模式 
		3.2适配器模式 
		3.3观察者模式 
>  4多线程问题：
 
		4.1生产者和消费者问题。
		
> 	5JDK源码： 

		5.1String 源码，为什么不可以修改。 
		5.2List、Map、Set实现类的源代码 
		5.3ReentrantLock、AQS的源代码 
		5.4线程池的实现原理 
		5.5Object类中的方法以及每个方法的作用 
		
> 	6数据库SQL语句 

		6.1join连接 
		6.2慢查询使用 
		
> 	7数据结构和算法分析 

		7.1数据结构-数组，链表，栈，队列，树，二叉树
			7.1.1链表的制作
		
		7.2冒泡算法，二分法算法，快速排序，插入排序等。 
		
> 	8java虚拟机JVN 

		8.1GC机制 
		8.2内存分配及其实现 
		8.3类加载机制
