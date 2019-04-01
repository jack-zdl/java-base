package com.zhang.io.nio;


import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * 功能说明:    <br>
 * 系统版本: 2.0 <br>
 * 开发人员: zhangdl <br>
 * 开发时间:2018/6/6 22:48<br>
 * <br>
 */
public class MultiplexerTimeServer implements Runnable {

    private Selector selector;

    private ServerSocketChannel servChannel;

    private volatile boolean stop;

    public MultiplexerTimeServer(int port){
        try {

            // 3 创建Reactor线程，创建多路复用器并启动线程。
            selector = Selector.open();

            // 1  打开ServerSocketChannel,用于监听客户端连接，他是所有客户端连接的父管道。
            servChannel = ServerSocketChannel.open();

            // 2  绑定监听端口，设置连接为非阻塞模式
            servChannel.configureBlocking(false);
            servChannel.socket().bind(new InetSocketAddress(port));
            // 4 将ServerSocketChannel注册到Reactor线程的多路复用器Selector上，监听ACCEPT事件
            // 将serverChannel注册到selector
            int interestSet = SelectionKey.OP_READ | SelectionKey.OP_WRITE;  //如果你对不止一种事件感兴趣，那么可以用“位或”操作符将常量连接起来，如下：
            SelectionKey selectionKey = servChannel.register(selector,SelectionKey.OP_ACCEPT);
//            selector.select();
            System.out.println("the time server is start in port :"+ port);
        }catch (IOException e){
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void stop(){
        this.stop = true;
    }

    @Override
    public void run() {
        while (!stop){
            try {
                selector.select(1000);
                Set<SelectionKey>  selectedKeys = selector.selectedKeys();
                Iterator<SelectionKey> it = selectedKeys.iterator();
                SelectionKey key = null;
                while (it.hasNext()){
                    key = it.next();
                    it.remove();
                    try {
                    handleInput(key);
                    }catch (Exception e){
                        if(key != null){
                            key.cancel();
                            if(key != null){
                                key.cancel();
                                if(key.channel() != null){
                                    key.channel().close();
                                }
                            }
                        }
                    }
                }
            }catch (Throwable t){
                t.printStackTrace();
            }
        }
        if(selector != null){
            try {
                selector.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    private void handleInput(SelectionKey key) throws IOException {
        if(key.isValid()){
            if(key.isAcceptable()){
                ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                SocketChannel sc = ssc.accept();
                sc.configureBlocking(false);
                sc.register(selector,SelectionKey.OP_READ);
            }
            if(key.isReadable()){
                SocketChannel sc = (SocketChannel) key.channel();
                ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                int readBytes = sc.read(readBuffer);
                if(readBytes > 0){
                    readBuffer.flip();
                    byte[] bytes = new byte[readBuffer.remaining()];
                    readBuffer.get(bytes);
                    String body = new String(bytes,"UTF-8");
                    System.out.println("The time server receive order :"+body);
                    String currenTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ? new java.util.Date(System.currentTimeMillis()).toString() : "BAD PRDER";
                    doWrite(sc,currenTime);
                }else if(readBytes < 0){
                    key.channel();
                    sc.close();
                }else {
                }
            }
        }
    }

    private void doWrite(SocketChannel channel, String response) throws IOException {
        if(response != null && response.trim().length() > 0){
            byte[] bytes = response.getBytes();
            ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
            writeBuffer.put(bytes);
            writeBuffer.flip();
            channel.write(writeBuffer);
        }
    }
}
