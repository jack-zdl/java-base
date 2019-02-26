package com.zhang.thread;


/*
 *@author zhangdelei@bsgchina.com
 *@data 2017��2��12������9:47:53
 *@Description ģ�������Ļ���
 *˫�������ŶԷ�����Դ���ţ�˫�����ȴ��Է��ͷ���Դ���γ�����
 *��ѧ�ҳԷ�����
 *�������  ���������ȼӴ�Щ
 */

public class JavaTestDeadLock implements Runnable {
	public int flag = 1;
	static Object o1 = new Object (), o2=new Object();

	@Override
	public void run() {
		/**
		 *@author  zhangdelei000@bsgchina.com
		 *@data 2017��2��12������9:47:53
		 *@Description TODO
		 */
		System.out.println("flag="+flag);
		if(flag == 1){
			synchronized(o1){
				try{
					Thread.sleep(500);
				}catch(Exception e){
					e.printStackTrace();
				}
				synchronized(o2){
					System.out.println("1");
				}
			}
		}
		if(flag == 0){
			synchronized(o2){
				try{
					Thread.sleep(500);
				}catch(Exception e){
					e.printStackTrace();
				}
				synchronized(o1){
					System.out.println("0");
				}
			}
		}

	}
	/*
	 * @author zhangdelei@bsgchina.com
	 * @data 2017��2��12������9:47:53
	 * @Description TODO
	*/
	public static void main(String[] args) {
		JavaTestDeadLock td1 = new JavaTestDeadLock();
		JavaTestDeadLock td2 = new JavaTestDeadLock();
		td1.flag=1;
		td2.flag=0;
		Thread t1 = new Thread(td1); //1 �½�״̬
		Thread t2 = new Thread(td2); 
		t1.start();  //2����״̬  ---3����ִ��run()����ʱ������״̬-4�߳����ڸ���ԭ���������״̬a ͨ��sleep() b IO����  c �ò����� 5 ����״̬ run()�����ӽ��� δ�����쳣��ֹ�߳�
		t2.start();
	}
}
