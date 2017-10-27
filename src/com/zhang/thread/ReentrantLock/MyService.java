package com.zhang.thread.ReentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhangdl
 * @version class v1.0
 * @date 2017/9/22 7:10
 */
public
class MyService {
    private Lock lock = new ReentrantLock();
    public void testMethod(){
        lock.lock();
        for (int i=0;i<5;i++){
            System.out.println("ThreadName="+Thread.currentThread().getName()+(" "+(i+1)));
        }
        lock.unlock();
    }
}
