

import java.io.IOException;
import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**@author  zhangdelei
 * @data 2017年3月11日下午3:02:11
 *@Description TODO
 */
public class TcpServer {

	/**@author  zhangdelei
	 * @throws IOException 
	 * @data 2017年3月11日下午3:02:11
	 *@Description 
	 *@TODO
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket ss = new ServerSocket(6666);
		while(true){
			Socket s = ss.accept();
			DataInputStream dis = new DataInputStream(s.getInputStream());
			System.out.println(dis.readUTF());
			dis.close();
			s.close();
			//ystem.out.println("connect A client");
		}
		
	}
	
}
