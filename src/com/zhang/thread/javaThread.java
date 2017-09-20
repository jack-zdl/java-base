package com.zhang.thread;
/*
 *@author zhangdelei@bsgchina.com
 *@data 2017��1��12������8:48:28
 *@Description һ��ͨ���̳нӿڵķ�ʽһ��ͨ���̳и���ķ�ʽ
 */
//implements Runnable 
class running extends Thread{
	@Override
	public void run() {
		/**
		 *@author  zhangdelei000@bsgchina.com
		 *@data 2017��1��12������8:48:28
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
		 *@data 2017��1��12������8:48:28
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

