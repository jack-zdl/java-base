package com.zhang.container;

import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 功能说明: ConcurrentHashMap线程安全类<br>
 * 系统版本: 2.0 <br>
 * 开发人员: zhangdl <br>
 * 开发时间: 2018/2/1 21:29<br>
 */

public class TestConcurrentHashMap {



    public static
    void main(String[] args) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("1","1");

    }
}
