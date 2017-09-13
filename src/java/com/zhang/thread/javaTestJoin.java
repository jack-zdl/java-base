package java.com.zhang.thread;
/*
 *@author zhangdelei@bsgchina.com
 *@data 2017��1��12������9:43:48
 *@Description ʹ���̵߳�join�����������������Լ�
 */

public class javaTestJoin {
	/*
	 * @author zhangdelei@bsgchina.com
	 * @data 2017��1��12������9:43:48
	 * @Description TODO
	*/
	public static void main(String[] args) {
		JoinThread jThread = new JoinThread("abc");
		jThread.start();
		try{
			jThread.join();
		}catch(InterruptedException e){
			return;
		}
		for(int i=0;i<10;i++){
			System.out.println("mainThread====");
		}
	}
	}
class JoinThread extends Thread{
	JoinThread(String s){super(s);}
	public void run(){
		for(int i=0;i<10;i++){
			System.out.println("I AM JoinThread==="+getName());
		}
	}
}
