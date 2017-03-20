package java.thread;


/*
 *@author zhangdelei@bsgchina.com
 *@data 2017年2月12日上午9:47:53
 *@Description 模拟死锁的机制
 *双方都拿着对方的资源不放，双方都等待对方释放资源，形成死锁
 *哲学家吃饭问题
 *解决方案  将锁的粒度加大些
 */

public class JavaTestDeadLock implements Runnable {
	public int flag = 1;
	static Object o1 = new Object (), o2=new Object();
	@Override
	public void run() {
		/**
		 *@author  zhangdelei000@bsgchina.com
		 *@data 2017年2月12日上午9:47:53
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
	 * @data 2017年2月12日上午9:47:53
	 * @Description TODO
	*/
	public static void main(String[] args) {
		JavaTestDeadLock td1 = new JavaTestDeadLock();
		JavaTestDeadLock td2 = new JavaTestDeadLock();
		td1.flag=1;
		td2.flag=0;
		Thread t1 = new Thread(td1);
		Thread t2 = new Thread(td2);
		t1.start();
		t2.start();
	}
}
