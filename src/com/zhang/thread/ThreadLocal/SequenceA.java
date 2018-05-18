package com.zhang.thread.ThreadLocal;

/**
 * 功能说明:  线程不安全  <br>
 * 系统版本: 2.0 <br>
 * 开发人员: zhangdl <br>
 * 开发时间:2018/5/18 22:44<br>
 * <br>
 */
public class SequenceA implements Sequence{

    private static int number = 0;

    @Override
    public int getNumber(){
        number = number +1;
        return number;
    }

    public static void main(String[] args) {
        Sequence sequence = new SequenceA();

        ClientThread thread1 = new ClientThread(sequence);
        ClientThread thread2 = new ClientThread(sequence);
        ClientThread thread3 = new ClientThread(sequence);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
