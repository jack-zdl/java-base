package com.zhang.thread.ReentrantLock;

/**
 * @author zhangdl
 * @version class v1.0
 * @date 2017/9/22 7:45
 */
public
class Main {
    public static
    void main(String[] args) {
        MyService myService = new MyService();
        MyThread myThread1 = new MyThread(myService);
        MyThread myThread2 = new MyThread(myService);
        MyThread myThread3 = new MyThread(myService);
        MyThread myThread4 = new MyThread(myService);
        myThread1.start();
        myThread2.start();
        myThread3.start();
        myThread4.start();
    }
}
