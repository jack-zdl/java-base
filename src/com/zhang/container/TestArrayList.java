package com.zhang.container;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

/**@author  zhangdelei
 * @data 2017年3月22日下午9:44:58
 *@Description 简单的数组增删改查
 *这里只是测试和学习arraylist使用方法
 *@description
 * 1 使用Collection 接口实现arrayList  已经没有get方法了 不赞同使用collection来实现list，因为很多方法都没有
 * 2 使用List接口 实现arrayList 
 * 3 iterator 迭代器的使用 1 提供统一的迭代方式 2 迭代器提供一种快速失败机制，防止多线程下的不安全操作，
 * 4 wait(),notify(),notifyAll()每个对象都有的  锁是每个对象都有的，操作锁是每个对象最基础的
 * wait是让当前线程等待，直到其他线程调用此对象的 notify() 方法或 notifyAll() 方法
 */

public class TestArrayList {
	
     @Test
     public void TestCollectionToArrayList(){
    	 Collection array = new ArrayList();
    	 array.add(2);
    	 array.add("2");
    	 System.out.println("collection array的一个对象是");
    	 List  arrayList = new ArrayList();
    	 arrayList.add("1"); //添加对象到arralist中
    	 arrayList.add(0, 1);//添加对象到指定的位置
    	 arrayList.addAll(array);//添加集合到这个集合
    	// arrayList.addAll(0, array);//添加集合到这个集合的指定位置
    	// arrayList.clear();//清除list中的所有元素
    	 System.out.println("元素是否存在:"+arrayList.contains("1"));//判断集合中是否有这个元素
    	 System.out.println("集合是否存在:"+arrayList.containsAll(array));
    	 System.out.println("判断集合是否相同:"+arrayList.equals(array));
    	 System.out.println("判断集合是否为空:"+arrayList.isEmpty());
    	 System.out.println("集合的迭代器"+arrayList.iterator());
    	 /////////iterator 迭代器
    	 Iterator iterator = arrayList.iterator();
    	 while(iterator.hasNext()){
    		 System.out.println("数据="+iterator.next());//不能有任何增删操作否者会触发快速失败机制
    	 }
    	 //arrayList.notify();//通知线程起来
    	 //arrayList.remove("1");//删除list中的第一个某个对象
    	 //arrayList.remove(1);//删除list指定位置的元素
    	 arrayList.removeAll(array); //删除集合中的某个集合
    	 System.out.println("arrayList="+arrayList);
    	 
    	 
     }
     
     
     
}
