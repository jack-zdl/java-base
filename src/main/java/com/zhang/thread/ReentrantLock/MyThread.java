package com.zhang.thread.ReentrantLock;

/**
 * @author zhangdl
 * @version class v1.0
 * @date 2017/9/22 7:48
 */
public
class MyThread extends Thread {

    private MyService myService ;
    public MyThread(MyService service){
        super();
        this.myService=service;
    }
    @Override
    public
    void run() {
        myService.testMethod();
    }
}
