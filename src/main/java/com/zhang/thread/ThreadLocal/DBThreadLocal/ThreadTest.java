package com.zhang.thread.ThreadLocal.DBThreadLocal;

import org.junit.Test;

/**
 * 功能说明:    <br>
 * 系统版本: 2.0 <br>
 * 开发人员: zhangdl <br>
 * 开发时间:2018/5/19 21:49<br>
 * <br>
 */
public class ThreadTest {

    static class ClientThread extends Thread{
        private ProductService productService;

        public ClientThread(ProductService productService){
            this.productService = productService;
        }

        @Override
        public void run(){
            System.out.println(Thread.currentThread().getName());
            System.out.println("===================="+(int)(1+Math.random()*10));
//            productService.updateProductPrice(1,3000);
        }
    }

    public static void main(String[] args) {
        for (int i = 0;i < 10;i++){
            ProductService productService = new ProductServiceImpl();
            ClientThread thread = new ClientThread(productService);
            thread.start();
        }
    }

    public void runTest(){
        for (int i = 0;i < 10;i++){
            ProductService productService = new ProductServiceImpl();
            ClientThread thread = new ClientThread(productService);
            thread.start();
        }
    }

}
