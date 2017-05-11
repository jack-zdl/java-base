package com.zhang.container;

import java.util.Stack;

import org.junit.Test;

/**@author  zhangdelei
 * @data 2017年5月10日下午9:18:51
 *@Description stack继承于Vector，实现了后进先出（LIFO）堆栈形式一个桶,提供了push,pop,peek
 *push 增加一个元素
 *pop 
 */

public class TestStack {
	
	@Test
	public void test(){
		Stack stack = new Stack();
		stack.push("1"); //添加元素进入桶
		System.out.println("stack的堆栈="+stack);
		stack.pop();//删除最后一个元素
		System.out.println("stack的堆栈="+stack);
		stack.peek();//获取最后一个元素
		System.out.println("stack的堆栈="+stack);
	}
	
}
