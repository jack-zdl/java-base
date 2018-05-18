package com.zhang.thread.ThreadLocal;

/**
 * 功能说明:    <br>
 * 系统版本: 2.0 <br>
 * 开发人员: zhangdl <br>
 * 开发时间:2018/5/18 22:40<br>
 * <br>
 */
public class ClientThread extends Thread{

    private Sequence sequence;

    public ClientThread (Sequence sequence){
        this.sequence = sequence;
    }

    @Override
    public void run(){
        for (int i = 0 ; i < 3 ; i ++){
            System.out.println(Thread.currentThread().getName()+" = > "+sequence.getNumber());
        }
    }
}
