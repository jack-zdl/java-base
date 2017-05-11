package com.zhang.container;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**@author  zhangdelei
 * @data 2017年3月22日下午9:07:17
 *@Description 测试链表（单链表，双链表） 这个是基于双向链表
 *	1   二个方法只有返回类型不同是不能区别他的的，
 *	2 LinkedList是非线程安全的
 */

public  class TestLinkedList {
	
	@Test
	public void testListLinkedList(){
		List linkedList = new LinkedList();
		//一样使用list接口的方法
		linkedList.add("1");
		System.out.println("链表="+linkedList);
	}
	  
	@Test
	public void testLink(){
		 LinkedList linkedList = new LinkedList(); 
		 linkedList.addFirst("1");
		 System.out.println("第一个元素="+linkedList.get(0));
		// linkedList.remove("1");
		 System.out.println("linkedList="+linkedList);
		 Iterator iterator = linkedList.iterator();
		 while(iterator.hasNext()){
			 System.out.println("数据="+iterator.next());
		 }
		 
	}
	
	
}
