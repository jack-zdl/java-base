package java.containerzhang;

import org.junit.Test;

/**@author  zhangdelei
 * @data 2017��3��22������9:07:17
 *@Description ��������������˫����
 *			1��������ֻ�з������Ͳ�ͬ�ǲ����������ĵģ�
 */

public  class TestLinkedList {
	
//	public int constans = 5;
//	{
//		constans = constans + 5;	//���ֶ���Ӧ��д�ڴ�����У������ڷ����У�������ʵ�������޷�ִ��
//	}
	
	//public abstract void method(int a);
	
	//public void method(){}
	  
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
