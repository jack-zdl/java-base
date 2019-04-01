package com.zhang.thread;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

/**
 * @Description:
 * @Author: dl.zhang
 * @CreateDate: 2019/2/26 12:51
 **/
public class JavaExecutor {


    @Test
    public void testThread() {
        ExecutorService  executorService = null;
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
            executorService = Executors.newFixedThreadPool(2);
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    cale(request);
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
                        cale1(request);
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
            final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            Future<String> future =  executorService.submit(new CallableTask());
            System.out.println("获取callable任务的结果：" + future.get() + "，现在时间是：" + sdf.format(new Date()));
            try {
//                ((ExecutorService) executorService).shutdown();

                countDownLatch.await();
                boolean isShutdown = executorService.isShutdown();
                System.out.println("线程池是否已经关闭"+isShutdown);

                if (!executorService.awaitTermination(1L,TimeUnit.SECONDS)) {
                    System.out.println("线程池中还有任务在执行，当前时间：" + sdf.format(new Date()));
                }
                System.out.println("线程池中已经没有在执行的任务，线程池已完全关闭！");
                System.out.println(request.getKeyword());
                System.out.println(request.getLocale());
                long endTime = System.currentTimeMillis(); //获取结束时间
                System.out.println("程序运行时间：" + (endTime - startTime) + "ms"); //输出程序运行时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }catch (Exception e){

        } finally {
            if (executorService != null) {
                executorService.shutdown();
            }
        }
    }

    public void testExecutorService(){
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        ExecutorService executorService1  = new ThreadPoolExecutor(2, 2,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
        ThreadFactory threadFactory =  new ThreadFactory(){
            @Override
            public Thread newThread(Runnable r) {
                return null;
            }
        };
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3, threadFactory);
        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
        ExecutorService executorService21 = Executors.newSingleThreadExecutor(threadFactory);
        Executor executorService3 = Executors.newCachedThreadPool();
        Executor executorService31 = Executors.newCachedThreadPool(threadFactory);
    }

    public void testThreadSchedule(){
        ScheduledExecutorService scheduledExecutorService =  Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.execute(new Runnable() {
            @Override
            public void run() {

            }
        });
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

class CallableTask implements  Callable<String>{

    @Override
    public String call() throws Exception {
        TimeUnit.SECONDS.sleep(5L);
        return "success";
    }

    public SearchRequestType callableSearchRequestType(SearchRequestType para) {
        try {
            Thread.sleep(4000);
            System.out.println("ce2");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        para.setLocale("2");
        return para;
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