package com.zhang.thread.ThreadLocal;

/**
 * 功能说明:    <br>
 * 系统版本: 2.0 <br>
 * 开发人员: zhangdl <br>
 * 开发时间:2018/5/18 22:50<br>
 * <br>
 */
public class SequenceB implements Sequence {

//    // 线程安全 变量
//    private static ThreadLocal<Integer> numberContainer = new ThreadLocal<Integer>(){
//        @Override
//        protected Integer initialValue(){
//            return 0;
//        }
//    };

    // 线程安全 变量
    private static MyThreadLocal<Integer> numberContainer = new MyThreadLocal<Integer>(){
        @Override
        protected Integer initialValue(){
            return 0;
        }
    };

    @Override
    public int getNumber() {
        numberContainer.set(numberContainer.get() + 1);
        return numberContainer.get();
    }

    public static void main(String[] args) {
        Sequence sequence = new SequenceB();

        ClientThread thread1 = new ClientThread(sequence);
        ClientThread thread2 = new ClientThread(sequence);
        ClientThread thread3 = new ClientThread(sequence);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
