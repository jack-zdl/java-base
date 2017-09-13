package java.com.zhang.container;

import java.util.Stack;

import org.junit.Test;

/**@author  zhangdelei
 * @data 2017��5��10������9:18:51
 *@Description stack�̳���Vector��ʵ���˺���ȳ���LIFO����ջ��ʽһ��Ͱ,�ṩ��push,pop,peek
 *push ����һ��Ԫ��
 *pop 
 */

public class TestStack {
	
	@Test
	public void test(){
		Stack stack = new Stack();
		stack.push("1"); //���Ԫ�ؽ���Ͱ
		System.out.println("stack�Ķ�ջ="+stack);
		stack.pop();//ɾ�����һ��Ԫ��
		System.out.println("stack�Ķ�ջ="+stack);
		stack.peek();//��ȡ���һ��Ԫ��
		System.out.println("stack�Ķ�ջ="+stack);
	}
	
}
