package com.zhang.tcp;

import java.io.OutputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TestClientServer{
	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(8888);
		
			Socket s = ss.accept();
			OutputStream os = s.getOutputStream();  
			DataOutputStream dos = new DataOutputStream(os);
			dos.writeUTF("server :hello "+s.getInetAddress()+"port:"+s.getPort()+"bey-bey");
			dos.close();
			s.close();
		
	}
}