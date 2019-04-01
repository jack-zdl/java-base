package com.zhang.thread.ThreadLocal;

/**
 *
 * @author zhangdl
 * @version class v1.0
 * @date 2017/9/21 10:16
 */
public
class ThreadLocalExt extends ThreadLocal{
    protected Object initialValue(){
        return "我是默认值 第一个Get不在为null";
    }
}
