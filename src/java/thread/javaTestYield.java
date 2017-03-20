package java.thread;
/*
 *@author zhangdelei@bsgchina.com
 *@data 2017年1月12日下午9:57:19
 *@Description yeild()的方法使用，自己线程让出cpu。让别人使用
 */

public class javaTestYield {

	public static void main(String[] args) {
//		Thread t1 = new Thread(new YieldThread());
//		Thread t2 = new Thread(new YieldThread());
		YieldThred2 t1 = new YieldThred2("aaa");
		YieldThred2 t2 = new YieldThred2("bbb");
		t1.start();t2.start();
		/**
		 *@author  zhangdelei000@bsgchina.com
		 *@data 2017年1月12日下午9:57:19
		 *@Description TODO
		 */
	}
}
class YieldThred2 extends Thread{
	YieldThred2(String s){super(s);}
	public void run() {
		for(int i=0;i<100;i++){
			System.out.println("I AM Yield=="+getName()+"-----"+i);
			if(i%10 ==0){
				yield();	
			}
		}
	}
}
class YieldThread implements  Runnable {
	
	public void run() {
		for(int i=0;i<100;i++){
			System.out.println("I AM Yield==");
			if(i%10 ==0){
				Thread.yield();	
			}
		}
	}
}