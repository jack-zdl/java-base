package com.zhang.io.nio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 功能说明:  BIO model class  <br>
 * 系统版本: 2.0 <br>
 * 开发人员: zhangdl <br>
 * 开发时间:2018/6/6 21:48<br>
 * <br>
 */
public class TimeServer {
    public static void main(String[] args) {
        int port = 9898;
        if(args != null && args.length > 0){
            try {
                port = Integer.valueOf(args[0]);
            }catch (NumberFormatException e){

            }
        }
        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);

        new  Thread(timeServer,"NIO-MultiplexerTimeServer-001").start();
    }
}
