# 线程的全部变量类
  保证所有线程得到这个全局变量，且各自有各自的值，简单来说获取时一样，执行时不相同。
> 1 基本语法： 

+	1.ThreadLocal()的使用

```
	使用一个类继承于ThreadLocal（）。可以使该类为线程共享的这个类。
    ThreadLocal 具体案例
    首先 通过ThreadLocal存放JDBC Connection,已达到事务控制的能力。
```
