# 单例模式
	这里主要讲解到单例模式的的问题以及需求。
	单例对象-线程池，配置文件对象

>  基本用法：

    建立一个private私有的构造函数，防止别其他人私自生成对象，只允许自己生成自己对象返回给外面。
	建立一个public的getInstance的方法，来获得一个对象，这个对象如果没有，就自己新建一个，如果已经有一个，就直接返回给他，
		
>  注意点：
 
	当开始没有当前对象时，这时如果有多线程来获取对象，就会出现线程问题，就会出现产生多个单例对象。为了规避这个问题， 
	采用synchronized锁的机制，在getInstance方法上加上synchronized，这样就可以避免产生多个对象，但是这样就浪费了很多性能资源。
	采用静态方法，在类上加上static 的单例对象，在类加载时就已经初始化成功了，但是这样就会造成资源浪费，
	如果该对象是极浪费资源的对象，那么不建议加载时就初始化，应该采用懒加载
	最好的方式，在getInstance内部加上synchronized,锁代码块的形式，只要他去新建一个单例对象时，就加锁。
	但是返回的代码之类的没有加锁。

>  考点
    
    Spring的单例模式和java的单例模式？
    在spring的单例模式，就是IOC容器模式中自动依赖注入的bean,这个bean时单例模式，所以要考虑线程安全。
        但是我们可以生成多个IOC容器。但是每个IOC容器生成的bean的都是单例模式。
    在java的单例模式，java中只有一个jvm,jvm中某个class只有一个实例。
    1 对于Spring中实现Singleton模式，是以IOC容器为单位（就是说在这个容器里面bean实现Singleton）
    一个JVM可能有多个IOC容器，而在这个容器里实现了singleton bean。 
    而Java中实现Singleton模式而言，只有一个JVM，jvm中某个class只有一个实例
    2 singleton模式中，singleton的class在整个JVM中只有一个instance， 
    Spring的Bean，你可以一个class配置多个Bean，这个class就有了多个instance。
    
        
		
