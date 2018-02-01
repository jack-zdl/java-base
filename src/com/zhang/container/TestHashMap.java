package com.zhang.container;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/**@author  zhangdelei
 * @data 2017��5��10������9:20:35
 *@Description hashmap�Ƿ��̰߳�ȫ����������뱣��˳���ʹ��treeMap
 * hashMap和hashTable的区别   必考题
 *
 */

public class TestHashMap {

	/**
	 * 内部类，在hashmap中也有
	 * Basic hash bin node, used for most entries.  (See below for
	 * TreeNode subclass, and in LinkedHashMap for its Entry subclass.)
	 */
	static class Node<K,V> implements Map.Entry<K,V> {
		final int hash;
		final K key;
		V value;
		Node<K,V> next;

		Node(int hash, K key, V value, Node<K,V> next) {
			this.hash = hash;
			this.key = key;
			this.value = value;
			this.next = next;
		}

		public final K getKey()        { return key; }
		public final V getValue()      { return value; }
		public final String toString() { return key + "=" + value; }

		public final int hashCode() {
			return Objects.hashCode(key) ^ Objects.hashCode(value);
		}

		public final V setValue(V newValue) {
			V oldValue = value;
			value = newValue;
			return oldValue;
		}

		public final boolean equals(Object o) {
			if (o == this)
				return true;
			if (o instanceof Map.Entry) {
				Map.Entry<?,?> e = (Map.Entry<?,?>)o;
				if (Objects.equals(key, e.getKey()) &&
						Objects.equals(value, e.getValue()))
					return true;
			}
			return false;
		}
	}



	/**
	 * 测试方法
	 */
	public void test(){
		Map<String,Object> hashMap = new HashMap<String,Object>();
		hashMap.put("1","1");//
		hashMap.put("2","2");
		hashMap.put("3","3");
		hashMap.put("4", "4");
		hashMap.put("5", "5");
		hashMap.put("6", "6");
		hashMap.put("7", "7");
		hashMap.put("8", "8");
		hashMap.put("9", "9");
		hashMap.put("10", "10");
//		hashMap.get("key");
		
	}



}

/**
 * 内部线程
 */
class RunnableDemo implements Runnable {
	private Map<String,Object> threadMap;

	RunnableDemo(Map<String,Object> map) {
		System.out.println("map是否为空 " +  map.isEmpty() );
		threadMap = map;
	}
	@Override
	public void run() {
		System.out.println("start" );
		try {
			for(int a = 20;a<30;a++){
				threadMap.put(""+a,a+1);

			}
		}catch (Exception e) {
			System.out.println("Thread  interrupted.");
		}
	}

	public static void main(String[] args) {
		Map<String,Object> hashMap = new HashMap<String,Object>();
		hashMap.put("1","1");//
		hashMap.put("2","2");
		hashMap.put("3","3");
		hashMap.put("4", "4");
		hashMap.put("5", "5");
		hashMap.put("6", "6");
		hashMap.put("7", "7");
		hashMap.put("8", "8");
		hashMap.put("9", "9");
		hashMap.put("10", "10");
		RunnableDemo t1 = new RunnableDemo( hashMap);
		t1.run();
		for (int b = 30;b<40;b++){
			hashMap.put(""+b,b+1);
		}
		System.out.println(hashMap);
		/**
		 * hashmap的安全迭代方式
		 */
		Iterator iter = hashMap.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			Object key = entry.getKey();
			Object val = entry.getValue();
		}
	}

}
