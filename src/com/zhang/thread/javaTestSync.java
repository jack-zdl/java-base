package com.zhang.thread;


/*
 *@author zhangdelei@bsgchina.com
 *@data 2017��2��11������9:34:49
 *@Description TODO
 */

public class javaTestSync implements Runnable {
	Timer timer = new Timer();
	public static void main(String[] args) {
		javaTestSync test = new javaTestSync();
		Thread t1 = new Thread(test);
		Thread t2 = new Thread(test);
		t1.setName("t1");
		t2.setName("t2");
		t1.start();
		t2.start();
	}
	@Override
	public void run() {
		/**
		 *@author  zhangdelei000@bsgchina.com
		 *@data 2017��2��11������9:34:49
		 *@Description TODO
		 */
		timer.add(Thread.currentThread().getName());
	}
	/*
	 * @author zhangdelei@bsgchina.com
	 * @data 2017��2��11������9:34:49
	 * @Description TODO
	*/
}
class Timer{
	private static int num=0;
	public synchronized void add(String name){
		//synchronized(this){
			num ++;
			try{
				Thread.sleep(1);
				System.out.println("jahahah");
			}catch(InterruptedException e){
				System.out.println(name+"���ǵ�"+num);
			}
		//}
	}
}
