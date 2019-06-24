package com.zhang.thread.ReentrantLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {
    private ReentrantReadWriteLock rw1 = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        final ReadWriteLockTest test = new ReadWriteLockTest();

        new Thread(){
            @Override
            public void run() {
                test.get(Thread.currentThread());
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                test.get(Thread.currentThread());
            }
        }.start();

    }

    public  void get(Thread thread) {
        try {
            rw1.writeLock().lock();
            long start = System.currentTimeMillis();
            while (System.currentTimeMillis() - start <= 1){
                System.out.println(thread.getName() + "正在写操作");
            }
            System.out.println(thread.getName() + "写操作完成");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rw1.writeLock().unlock();
        }

    }
}
