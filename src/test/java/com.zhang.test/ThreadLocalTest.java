package com.zhang.test;

import com.zhang.thread.ThreadLocal.DBThreadLocal.ThreadTest;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ThreadLocalTest {
     /**
      * @BeforeAll 只执行一次，执行时机是在所有测试和 @BeforeEach 注解方法之前。
      */
     @BeforeAll
     static void initAll() {
     }

     /**
      * @BeforeEach 在每个测试执行之前执行。
      */
     @BeforeEach
     void init() {
     }

    @Test
    void threadTest(){
        System.out.println("11111");
        ThreadTest threadTes = new ThreadTest();
        threadTes.runTest();
    }

     @Test
     void standardAssertions() {
         assertEquals(2, 2);
         assertEquals(4, 4, "The optional assertion message is now the last parameter.");
         assertTrue(2 == 2, () -> "Assertion messages can be lazily evaluated -- "
                 + "to avoid constructing complex messages unnecessarily.");
     }

     /**
      * @AfterEach 在每个测试执行之后执行。
      */
     @AfterEach
     void tearDown() {
     }

     /**
      * @AfterAll只执行一次，执行时机是在所有测试和 @AfterEach 注解方法之后。
      */
     @AfterAll
     static void tearDownAll() {
     }
}
