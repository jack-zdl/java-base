package com.zhang.thread.ReentrantLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadLockTest {

    private ReentrantReadWriteLock rw1 = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        final ReadLockTest test = new ReadLockTest();

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
            rw1.readLock().lock();
            long start = System.currentTimeMillis();
            while (System.currentTimeMillis() - start <= 1){
                System.out.println(thread.getName() + "正在读操作");
            }
            System.out.println(thread.getName() + "读操作完成");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rw1.readLock().unlock();
        }

    }
}
