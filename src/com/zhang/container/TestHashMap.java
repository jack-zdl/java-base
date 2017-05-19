package com.zhang.container;

import java.util.HashMap;
import java.util.Map;

/**@author  zhangdelei
 * @data 2017年5月10日下午9:20:35
 *@Description hashmap是非线程安全，无序如何想保持顺序就使用treeMap
 */

public class TestHashMap {

	public void test(){
		Map<String,Object> hashMap = new HashMap<String,Object>();
		hashMap.put("key", "1");//添加一个key value
		hashMap.get("key");
		
	}
}
