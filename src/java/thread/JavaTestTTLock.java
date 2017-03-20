package java.thread;


/*
 *@author zhangdelei@bsgchina.com
 *@data 2017年2月12日上午10:16:32
 *@Description 锁住一个函数，其他函数是不是也锁住了
 */

public class JavaTestTTLock implements Runnable {
	public int b =100;
	public synchronized void m1() throws Exception{
		b=1000;
		Thread.sleep(5000);
		System.out.println("b="+b);
	}
	public void m2(){
		System.out.println(b);
	}
	@Override
	public void run() {
		try{
			m1();
		}catch(Exception e){
			e.printStackTrace();
		}

	}
	/*
	 * @author zhangdelei@bsgchina.com
	 * @data 2017年2月12日上午10:16:32
	 * @Description TODO
	*/
	public static void main(String[] args) throws Exception {
		JavaTestTTLock tt = new JavaTestTTLock();
		Thread t = new Thread(tt);
		t.start();
		Thread.sleep(1000);
		tt.m2();
	}
}
