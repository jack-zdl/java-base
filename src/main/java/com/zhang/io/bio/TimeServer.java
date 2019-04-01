package com.zhang.io.bio;

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
    public static void main(String[] args) throws IOException {
        int port = 9898;
        if(args != null && args.length > 0){
            try {
                port = Integer.valueOf(args[0]);
            }catch (NumberFormatException e){

            }
        }
        ServerSocket ss = null;
        try {
            ss = new ServerSocket(port);
            System.out.println(" the time server is start in port :"+port);
            Socket socket = null;
            while (true){
                socket = ss.accept();
                new Thread(new TimerServerHander(socket)).start();
            }
        }finally {
            if(ss != null){
                System.out.println("the time server close");
                ss.close();
                ss = null;
            }
        }
    }
}
