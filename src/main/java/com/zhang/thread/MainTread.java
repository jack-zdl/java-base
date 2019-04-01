package com.zhang.thread;

/**
 * @author zhangdl
 * @version class v1.0
 * @date 2017/9/16 22:00
 */
public class MainTread {
    public static void main(String[] args) {
        MThread myThread1 = new MThread();
//        MThread myThread2 = new MThread("B");
//        MThread myThread3 = new MThread("C");
//        MThread myThread4 = new MThread("D");
//        Thread a = new Thread(myThread1,"A");
//        Thread b = new Thread(myThread1,"B");
//        Thread c = new Thread(myThread1,"C");
//        Thread d = new Thread(myThread1,"D");

//        System.out.println("线程唯一标识="+myThread1.getId());
//        System.out.println("a="+myThread1.isAlive());
        myThread1.start();
//        System.out.println("b="+myThread1.isAlive());
//        b.start();
//        c.start();
//        d.start();
//        System.out.println(Thread.currentThread().getName());
    }
}

/**
 * 1 测试线程不共享变量的情况下
 */
 class MThread extends Thread{
    private int count = 5;
//    public MThread(String name){
//        super();
//        this.setName(name);
//    }

    synchronized  public void run(){
        super.run();
//        while (count>0){
            count--;
//            System.out.println("由"+this.currentThread().getName()+"计算count="+count);
          try {
            this.stop();
          }catch (ThreadDeath e){
              System.out.println("进入Catch方法");
              e.printStackTrace();
          }
            this.stop();
//        try {
//            Thread.sleep(1000);
//            System.out.println("获得线程唯一标识="+this.getId());
//            System.out.println("线程当前的状态="+this.isAlive());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        }
//        System.out.println("MyThread");
    }
}
