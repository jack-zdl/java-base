package com.zhang.design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 模拟动态代理
 */
public class JDKDynamicProxy implements InvocationHandler {

    private Object tager;

    public JDKDynamicProxy(Object target){
        this.tager = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("-------------代理之前------------------");
        Object result = method.invoke(tager,args);
        System.out.println("-------------代理之后------------------");
        return result;
    }
}
