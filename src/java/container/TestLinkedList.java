package java.container;

/**@author  zhangdelei
 * @data 2017年3月22日下午9:07:17
 *@Description 测试链表（单链表，双链表）
 *			1二个方法只有返回类型不同是不能区别他的的，
 */

public abstract class TestLinkedList {
	
	public int constans = 5;
	{
		constans = constans + 5;	//这种东西应该写在代码块中，或者在方法中，或者是实例化后无法执行
	}
	
	public abstract void method(int a);
	
	public void method(){}
	
	
}
