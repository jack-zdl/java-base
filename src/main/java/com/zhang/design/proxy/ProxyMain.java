package com.zhang.design.proxy;


import java.lang.reflect.Proxy;

/**
 * 代理模式
 * JDK动态代理
 */
public class ProxyMain {

    public static void main(String[] args) {
        Hello hello = new HelloImpl();
        JDKDynamicProxy dynamicProxyManager = new JDKDynamicProxy(hello);
        Hello helloProxy = (Hello)Proxy.newProxyInstance(
                hello.getClass().getClassLoader(),
                hello.getClass().getInterfaces(),
                dynamicProxyManager
        );
        helloProxy.say("Jack");
    }
}
