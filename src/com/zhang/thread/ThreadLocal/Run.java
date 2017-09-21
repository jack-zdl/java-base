package com.zhang.thread.ThreadLocal;

/**
 * @author zhangdl
 * @version class v1.0
 * @date 2017/9/21 10:32
 * @description 执行方法 测试所有线程得到的东西是否一样
 */
public
class Run {
    public static ThreadLocalExt t1 = new ThreadLocalExt();

    public static void main(String[] args) {
        if(t1 == null){
            t1.set("我的值");
        }
        System.out.println(t1.get());
        System.out.println(t1.get());
    }
}
