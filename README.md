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
+   1.6 Serializable接口
```
    1 序列化问题
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
> 3设计模式：23种设计模式。
 
		3.1工厂模式 
		3.2适配器模式 
		3.3观察者模式 
> 4多线程问题：
 
		4.1生产者和消费者问题。
		
> 5JDK源码： 

		5.1String 源码，为什么不可以修改。 
		5.2List、Map、Set实现类的源代码 
		5.3ReentrantLock、AQS的源代码 
		5.4线程池的实现原理 
		5.5Object类中的方法以及每个方法的作用 
		
> 6数据库SQL语句 

		6.1join连接 
		6.2慢查询使用 
		
> 7数据结构和算法分析 

		7.1数据结构-数组，链表，栈，队列，树，二叉树
			7.1.1链表的制作
		
		7.2冒泡算法，二分法算法，快速排序，插入排序等。 
			
> 8java虚拟机JVN

    8.1 GC机制 ：GC的主要是在堆，
   
	8.2 内存分配及其实现 
	    栈：线程单独享有，每个线程对应着一个虚拟机栈，因此虚拟机栈也是线程私有的
	        1 虚拟机栈，在虚拟栈中存放  a 局部变量表 b 操作站 c 动态链接 d 方法出口
	                    a 局部变量表 存储着方法的相关局部变量.包括各种基本数据类型，对象的引用，返回地址等
	                      只有long和double类型会占用2个局部变量空间（Slot，对于32位机器，一个Slot就是32个bit），
	                      其它都是1个Slot，局部变量表是在编译时就已经确定好的，方法运行所需要分配的空间在栈帧中是完全确定的，
	                      在方法的生命周期内都不会改变。
	                    d 方法出口（当方法被调用时，栈帧在JVM栈中入栈，当方法执行完成时，栈帧出栈）
	        2 本地方法栈 ：虚拟机栈是执行Java方法的，而本地方法栈是用来执行native方法的，
	                      在很多虚拟机中（如Sun的JDK默认的HotSpot虚拟机），会将本地方法栈与虚拟机栈放在一起使用。
	                      线程私有。
	    堆：
	    年轻代 对象创建时，停止-复制清理法，Minor GC
	        （8）Eden: 绝大多数刚创建的对象会被分配在Eden区，其中的大多数对象很快就会消亡。
	             Eden区是连续的内存空间，因此在其上分配内存极快
	             最初一次，当Eden区满的时候，执行Minor GC，将消亡的对象清理掉，
	             并将剩余的对象复制到一个存活区Survivor0（此时，Survivor1是空白的，两个Survivor总有一个是空白的)
	             下次Eden区满了，再执行一次Minor GC，将消亡的对象清理掉，将存活的对象复制到Survivor1中，然后清空Eden区
	        （1）Survivor0: 来记录对象的清理数次。在HotSpot切换15次，就可以进去老年代。
	        （1）Survivor1:
        年老代 Major GC，也叫 Full GC。标记-整理算法。标记出仍然存活的对象（存在引用的），将所有存活的对象向一端移动，
             以保证内存的连续。在发生Minor GC时，虚拟机会检查每次晋升进入老年代的大小是否大于老年代的剩余空间大小，如果大于，
             则直接触发一次Full GC，
             如果对象比较大（比如长字符串或大数组），Young空间不足，则大对象会直接分配到老年代上
            （大对象可能触发提前GC，应少用，更应避免使用短命的大对象）。
            可能存在年老代对象引用新生代对象的情况，如果需要执行Young GC，则可能需要查询整个老年代以确定是否可以清理回收，
            这显然是低效的。解决的方法是，年老代中维护一个512 byte的块——”card table“，所有老年代对象引用新生代对象的记
            录都记录在这里。Young GC时，只要查这里即可，不用再去查全部老年代，因此性能大大提高。
        永久代（方法区）常量池中的常量，无用的类信息，
            类的所有实例都已经被回收
            加载类的ClassLoader已经被回收
            类对象的Class对象没有被引用（即没有通过反射引用该类的地方）
            则将类信息进行回收。
	8.3 类加载机制

