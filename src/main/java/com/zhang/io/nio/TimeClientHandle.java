package com.zhang.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * 功能说明:    <br>
 * 系统版本: 2.0 <br>
 * 开发人员: zhangdl <br>
 * 开发时间:2018/6/7 21:59<br>
 * <br>
 */
public class TimeClientHandle implements Runnable{

    private String host;

    private int port;

    private Selector selector;

    private SocketChannel socketChannel;

    private volatile boolean stop;

    public TimeClientHandle(String host,int port){
        this.host = host == null ? "127.0.0.1" : host;
        this.port = port;
        System.out.println("11111");
        try {
            // 创建Reactor线程，创建多路复用器并启动线程
            selector = Selector.open();
            // 打开SocketChannel,绑定客户端本地地址，可选，但是模式系统会随机分配一个可用的本地地址
            socketChannel = SocketChannel.open();
            // 设置为非阻塞模式
            socketChannel.configureBlocking(false);
        }catch (IOException e){
            e.printStackTrace();
            System.exit(1);
        }
    }

    @Override
    public void run() {
        System.out.println("222");
        try {
            doConnect();
        }catch (IOException e){
            e.printStackTrace();
            System.exit(1);
        }
        while (!stop){
            try {
                // 多用复用器 轮询准备就绪的key
                selector.select(3000);
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> it = selectionKeys.iterator();
                SelectionKey key = null;
                while (it.hasNext()){
                    key = it.next();
                    it.remove();
                    try {
                        handerInput(key);
                    }catch (Exception e){
                        if(key != null){
                            key.channel();
                            if(key.channel() != null){
                                key.channel().close();
                            }
                        }
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
                System.exit(1);
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


    private void handerInput(SelectionKey key) throws IOException {
        if(key.isValid()){
            SocketChannel sc = (SocketChannel) key.channel();
            if(key.isConnectable()){
                if(sc.finishConnect()){
                    sc.register(selector,SelectionKey.OP_READ);
                    doWrite(sc);
                }else {
                    System.exit(1);
                }
                if(key.isReadable()){
                    ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                    int readBytes = sc.read(readBuffer);
                    if(readBytes > 0 ){
                        readBuffer.flip();
                        byte[] bytes = new byte[readBuffer.remaining()];
                        readBuffer.get(bytes);
                        String body = new String(bytes,"UTF-8");
                        System.out.println("Now is:"+body);
                        this.stop = true;
                    }else if(readBytes <0){
                        key.cancel();
                        sc.close();
                    }else {
                    }
                }
            }
        }
    }

    /**
     * 异步连接服务器
     *  判断是否连接成功，如果连接成功，直接注册读状态位到多路复用器，
     *  如果没有连接成功（异步连接，返回false.说明客户端已经发生sync包，服务端没有返回ack包，物理链路没有建立）
     * @throws IOException
     */
    private void doConnect() throws IOException {
        if(socketChannel.connect(new InetSocketAddress(host,port))){
            socketChannel.register(selector,SelectionKey.OP_READ);
        }else {
            // 向Reactor线程多路复用器注册 OP_CONNECT状态位，监听服务端TCP ACK应答
            socketChannel.register(selector,SelectionKey.OP_CONNECT);
        }
    }


    private void doWrite(SocketChannel sc) throws IOException {
        byte[] req = "QUERY TIME ORDER".getBytes();
        ByteBuffer writeBuffer = ByteBuffer.allocate(req.length);
        writeBuffer.put(req);
        writeBuffer.flip();
        sc.write(writeBuffer);
        if(! writeBuffer.hasRemaining()){
            System.out.println("Send order 2 server success");
        }
    }
}
