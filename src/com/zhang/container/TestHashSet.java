package com.zhang.container;


import com.zhang.sort.User;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**@author  zhangdelei
 * @data  2017/5/10 9:19:55
 *@Description TODO
 */

public class TestHashSet {
	
	public static void test(){
		Set hashSet = new HashSet();
		hashSet.add("1111");
		hashSet.add("1111");
		User user = new User(1,1);
		User user1 = new User(1,1);
		hashSet.add(user);
		hashSet.add(user1);
		hashSet.remove("1111");   // hashMap的remove方法
		hashSet.contains("1111");
		Iterator iterator = hashSet.iterator();
		while(iterator.hasNext()){
			Object obj = iterator.next();
			System.out.println(obj.toString());
		}
	}

	public static void main(String[] args) {
		test();
	}
}
