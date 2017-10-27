# Lock的学习
  使用local相关的类，来解决synchronized的锁问题，同事解决synchronized的性能问题。
> 1 基本语法： 

+	1.ReentrantLock类的使用

```
	Lock lock = new ReentrantLock(),
	lock.lock(),开始锁代码。
	lock.unlock().结束锁代码。

```
