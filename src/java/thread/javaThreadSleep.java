package java.thread;
/*
 *@author zhangdelei@bsgchina.com
 *@data 2017年1月12日下午9:18:32
 *@Description 将线程sleep掉，和stop掉，或者让他自动循环关闭
 */

import java.util.Date;

public class javaThreadSleep  {
	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		myThread.start();
		try{
			Thread.sleep(10000);
		}catch(InterruptedException e){	}
		//myThread.interrupt();
		//myThread.stop();
		myThread.flag=false;
	}
}
/**
 * @author zhangdelei@bsgchina.com
 * @data 2017年1月12日下午9:22:58
 * @Descriptiion TODO
 */
class MyThread extends Thread{
	boolean flag = true;
	public void run(){
		while(flag){
			System.out.println("thread ==="+new Date());
			try{
				sleep(1000);
			}catch(InterruptedException e){
				return;
			}
		}
	}
}
