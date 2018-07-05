package com.zhang.io.nio;

/**
 * 功能说明:    <br>
 * 系统版本: 2.0 <br>
 * 开发人员: zhangdl <br>
 * 开发时间:2018/6/7 22:22<br>
 * <br>
 */
public class TimeClient {
    public static void main(String[] args) {
        int port = 9898;
        if(args != null && args.length >0){
            try {
                port = Integer.valueOf(args[0]);
            }catch (NumberFormatException e){

            }
        }
        new Thread(new TimeClientHandle("127.0.0.1",port),"TimeClient-001").start();
    }
}
