package com.zhang.thread;

import org.junit.Test;
import java.util.concurrent.*;

/**
 * @Description:
 * @Author: dl.zhang
 * @CreateDate: 2019/2/26 12:51
 **/
public class JavaExecutor {


    @Test
    public void testThread() {
        try {
            long startTime = System.currentTimeMillis(); //获取开始时间
            SearchRequestType request = new SearchRequestType();
// Semaphore semaphore = new Semaphore(2);
// CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new Runnable() {
// @Override
// public void run() {
// System.out.println(request.getKeyword());
// System.out.println(request.getLocale());
// long endTime = System.currentTimeMillis(); //获取结束时间
// System.out.println("程序运行时间：" + (endTime - startTime) + "ms"); //输出程序运行时间
// }
// });
            CountDownLatch countDownLatch = new CountDownLatch(2);
            Executor executorService = Executors.newFixedThreadPool(2);
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        cale(request);
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    countDownLatch.countDown();
// try {
//// cyclicBarrier.await();
// } catch (InterruptedException e) {
// e.printStackTrace();
// } catch (BrokenBarrierException e) {
// e.printStackTrace();
// }
                }
            });
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        cale1(request);
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
// try {
// cyclicBarrier.await();
// } catch (InterruptedException e) {
// e.printStackTrace();
// } catch (BrokenBarrierException e) {
// e.printStackTrace();
// }
                    countDownLatch.countDown();
                }
            });
            try {
                countDownLatch.await();
                System.out.println(request.getKeyword());
                System.out.println(request.getLocale());
                long endTime = System.currentTimeMillis(); //获取结束时间
                System.out.println("程序运行时间：" + (endTime - startTime) + "ms"); //输出程序运行时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }catch (Exception e){

        }

    }

    public void cale(SearchRequestType para) {
        try {
            Thread.sleep(4000);
            System.out.println("ce1");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        para.setKeyword("1");
    }

    public void cale1(SearchRequestType para) {
        try {
            Thread.sleep(4000);
            System.out.println("ce2");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        para.setLocale("2");
    }
}

class SearchRequestType{

    private String Keyword;
    private String locale;

    public String getKeyword() {
        return Keyword;
    }

    public void setKeyword(String keyword) {
        Keyword = keyword;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }
}