package com.zhang.thread.ThreadLocal;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 功能说明:    <br>
 * 系统版本: 2.0 <br>
 * 开发人员: zhangdl <br>
 * 开发时间:2018/5/18 22:58<br>
 * <br>
 */
public class MyThreadLocal<T> {

    private Map<Thread,T> container = Collections.synchronizedMap(new HashMap<>());

    public void set(T value){
        container.put(Thread.currentThread(),value);
    }

    public T get() {
        Thread thread = Thread.currentThread();
        T value = container.get(thread);
        if(value == null && !container.containsKey(thread)){
            value =initialValue();
            container.put(thread,value);
        }
        return value;
    }

    public void remove(){
        container.remove(Thread.currentThread());
    }

    protected T initialValue(){
        return null;
    }

}
