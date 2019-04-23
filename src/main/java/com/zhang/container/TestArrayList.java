package com.zhang.container;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


/**@author  zhangdelei
 * @data 2017��3��22������9:44:58
 *@Description �򵥵�������ɾ�Ĳ�
 *����ֻ�ǲ��Ժ�ѧϰarraylistʹ�÷���
 *@description
 * 1 ʹ��Collection �ӿ�ʵ��arrayList  �Ѿ�û��get������ ����ͬʹ��collection��ʵ��list����Ϊ�ܶ෽����û��
 * 2 ʹ��List�ӿ� ʵ��arrayList 
 * 3 iterator ��������ʹ�� 1 �ṩͳһ�ĵ�����ʽ 2 �������ṩһ�ֿ���ʧ�ܻ��ƣ���ֹ���߳��µĲ���ȫ������
 * 4 wait(),notify(),notifyAll()ÿ�������е�  ����ÿ�������еģ���������ÿ�������������
 * wait���õ�ǰ�̵߳ȴ���ֱ�������̵߳��ô˶���� notify() ������ notifyAll() ����
 */

public class TestArrayList {
	
     public void TestCollectionToArrayList(){
    	 Collection array = new ArrayList();
    	 array.add(2);
    	 array.add("2");
    	 System.out.println("collection array��һ��������");
    	 List  arrayList = new ArrayList();
    	 arrayList.add("1"); //��Ӷ���arralist��
    	 arrayList.add(0, 1);//��Ӷ���ָ����λ��
    	 arrayList.addAll(array);//��Ӽ��ϵ��������
    	// arrayList.addAll(0, array);//��Ӽ��ϵ�������ϵ�ָ��λ��
    	// arrayList.clear();//���list�е�����Ԫ��
    	 System.out.println("Ԫ���Ƿ����:"+arrayList.contains("1"));//�жϼ������Ƿ������Ԫ��
    	 System.out.println("�����Ƿ����:"+arrayList.containsAll(array));
    	 System.out.println("�жϼ����Ƿ���ͬ:"+arrayList.equals(array));
    	 System.out.println("�жϼ����Ƿ�Ϊ��:"+arrayList.isEmpty());
    	 System.out.println("���ϵĵ�����"+arrayList.iterator());
    	 /////////iterator ������
    	 Iterator iterator = arrayList.iterator();
    	 while(iterator.hasNext()){
    		 System.out.println("����="+iterator.next());//�������κ���ɾ�������߻ᴥ������ʧ�ܻ���
    	 }
    	 //arrayList.notify();//֪ͨ�߳�����
    	 //arrayList.remove("1");//ɾ��list�еĵ�һ��ĳ������
    	 //arrayList.remove(1);//ɾ��listָ��λ�õ�Ԫ��
    	 arrayList.removeAll(array); //ɾ�������е�ĳ������
    	 System.out.println("arrayList="+arrayList);
    	 
    	 
     }

     @Test
	public void TestArrayListAddNull(){
		List<Node> list = new ArrayList<>();
		list.add(null);
		System.out.println("===="+list.toString());
	}
     
     
     
}
