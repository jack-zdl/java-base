package java.thread;
/*
 *@author zhangdelei@bsgchina.com
 *@data 2017年1月12日下午9:43:48
 *@Description 使用线程的join方法，来优先运行自己
 */

public class javaTestJoin {
	/*
	 * @author zhangdelei@bsgchina.com
	 * @data 2017年1月12日下午9:43:48
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
