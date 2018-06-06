package com.zhang.io.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * 功能说明:    <br>
 * 系统版本: 2.0 <br>
 * 开发人员: zhangdl <br>
 * 开发时间:2018/6/6 21:58<br>
 * <br>
 */
public class TimerServerHander implements Runnable {

    private Socket socket;

    public TimerServerHander(Socket socket){
        this.socket=socket;
    }

    @Override
    public void run(){
        BufferedReader in = null;
        PrintStream out = null;
        try {
            in =new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            out= new PrintStream(this.socket.getOutputStream(),true);
            String currentTime = null;
            String body = null;
            while (true){
                body = in.readLine();
                if (body == null){
                    break;
                }
                System.out.println("the time server receive order :"+body);
                currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body)?new java.util.Date(System.currentTimeMillis()).toString():"BAD ORDER";
                out.println(currentTime);
            }
        }catch (Exception e){
            if(in != null){
                try {
                    in.close();
                }catch (IOException e1){
                    e1.printStackTrace();
                }
            }
            if (out != null){
                out.close();
                out = null;
            }
            if (this.socket != null){
                try {
                    this.socket.close();
                }catch (IOException e2){
                    e2.printStackTrace();
                }
                this.socket = null;
            }
        }
    }
}
