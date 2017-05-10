package com.zhang.container;

import org.junit.Test;

/**@author  zhangdelei
 * @data 2017年3月22日下午9:07:17
 *@Description 测试链表（单链表，双链表） 这个是基于双向链表
 *			1二个方法只有返回类型不同是不能区别他的的，
 */

public  class TestLinkedList {
	

	  
	@Test
	public void testLink(){
		 LinkList linkList = new LinkList();  
	      linkList.addFirstNode(20);  
	      //linkList.addFirstNode(21);  
	      //linkList.addFirstNode(19);  
	       //19,21,20  
	      linkList.add(1, 22); //19,22,21,20  
	      linkList.add(2, 23); //19,22,23,21,20  
	      linkList.add(3, 99); //19,22,23,99,21,20  
	      linkList.displayAllNodes(); 
	      Node node = linkList.deleteByData(19);  
//        Node node = linkList.deleteByPos(0);  
          System. out.println( "node : " + node. data);  
          linkList.displayAllNodes();  
          Node node1 = linkList.findByPos(0);  
          System. out.println( "node1: " + node1. data);  
          Node node2 = linkList.findByData(22);  
          System. out.println( "node2: " + node2. data); 
	}
	
	
}
