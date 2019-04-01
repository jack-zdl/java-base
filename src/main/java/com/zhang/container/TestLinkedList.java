package com.zhang.container;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**@author  zhangdelei
 * @data 2017��3��22������9:07:17
 *@Description ��������������˫���� ����ǻ���˫������
 *	1   ��������ֻ�з������Ͳ�ͬ�ǲ����������ĵģ�
 *	2 LinkedList�Ƿ��̰߳�ȫ��
 */

public  class TestLinkedList {
	
	public void testListLinkedList(){
		List linkedList = new LinkedList();
		//һ��ʹ��list�ӿڵķ���
		linkedList.add("1");
		System.out.println("����="+linkedList);
	}
	  
	public void testLink(){
		 LinkedList linkedList = new LinkedList(); 
		 linkedList.addFirst("1");
		 System.out.println("��һ��Ԫ��="+linkedList.get(0));
		// linkedList.remove("1");
		 System.out.println("linkedList="+linkedList);
		 Iterator iterator = linkedList.iterator();
		 while(iterator.hasNext()){
			 System.out.println("����="+iterator.next());
		 }
		 
	}
	
	
}
