package java.com.zhang.tcp;

import java.io.InputStream;
import java.io.DataInputStream;
import java.net.Socket;
public class TestServerClient{
	public static void main(String[] args) throws  Exception{
		Socket s = new Socket("127.0.0.1",8888);
		InputStream is = s.getInputStream();
		DataInputStream dis =new DataInputStream(is);
		System.out.println(dis.readUTF());
		dis.close();
		s.close();
	}
}