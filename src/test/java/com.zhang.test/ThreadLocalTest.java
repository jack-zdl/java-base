package com.zhang.test;

import com.zhang.thread.ThreadLocal.DBThreadLocal.ThreadTest;
import org.junit.Test;

public class ThreadLocalTest {

    @Test
    public void threadTest(){
        System.out.println("11111");
        ThreadTest threadTes = new ThreadTest();
        threadTes.runTest();
    }
}
