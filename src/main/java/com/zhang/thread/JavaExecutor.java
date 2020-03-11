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

    /**
     * 使用原生的线程池方法
     */
    /**
     * handler
     * 线程池的饱和策略，当阻塞队列满了，且没有空闲的工作线程，如果继续提交任务，必须采取一种策略处理该任务，线程池提供了4种策略：
     * 1、AbortPolicy：直接抛出异常，默认策略；
     * 2、CallerRunsPolicy：用调用者所在的线程来执行任务；
     * 3、DiscardOldestPolicy：丢弃阻塞队列中靠最前的任务，并执行当前任务；
     * 4、DiscardPolicy：直接丢弃任务；
     * 当然也可以根据应用场景实现RejectedExecutionHandler接口，自定义饱和策略，如记录日志或持久化存储不能处理的任务。
     */
    public void testExecutorService(){
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        ExecutorService executorService1  = new ThreadPoolExecutor(2, 2,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
        SearchRequestType request = new SearchRequestType();
        executorService1.execute(new Runnable() {
            @Override
            public void run() {
                cale(request);
            }
        });
        /**
         * 队列
         * 1、ArrayBlockingQueue：基于数组结构的有界阻塞队列，按FIFO排序任务；
         * 2、LinkedBlockingQuene：基于链表结构的阻塞队列，按FIFO排序任务，吞吐量通常要高于ArrayBlockingQuene；
         * 3、SynchronousQuene：一个不存储元素的阻塞队列，每个插入操作必须等到另一个线程调用移除操作，否则插入操作一直处于阻塞状态，吞吐量通常要高于LinkedBlockingQuene；
         * 4、priorityBlockingQuene：具有优先级的无界阻塞队列；
         */

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