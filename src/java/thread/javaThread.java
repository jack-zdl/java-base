package java.thread;
/*
 *@author zhangdelei@bsgchina.com
 *@data 2017年1月12日下午8:48:28
 *@Description 一种通过继承接口的方式一种通过继承父类的方式
 */
//implements Runnable 
class running extends Thread{
	@Override
	public void run() {
		/**
		 *@author  zhangdelei000@bsgchina.com
		 *@data 2017年1月12日下午8:48:28
		 *@Description TODO
		 */
		for(int i=0;i<100;i++){
			System.out.println("running---"+i);
		}
	}
}
public class javaThread  {

	public static void main(String[] args) {
		/**
		 *@author  zhangdelei000@bsgchina.com
		 *@data 2017年1月12日下午8:48:28
		 *@Description TODO
		 */
		running r = new running();
		//r.run();
		Thread t = new Thread(r);
		t.start();
		for(int i=0;i<100;i++){
			System.out.println("main thread=="+i);
		}
		
	}
}

