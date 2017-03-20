

import java.io.IOException;
import java.io.OutputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Socket s = new Socket("127.0.0.1",6666);
		OutputStream os = s.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		Thread.sleep(3000);
		dos.writeUTF("HELLO SERVER");
		dos.flush();
		dos.close();
		s.close();
	}
	/**@author  zhangdelei
	 * @data 2017年3月11日下午3:05:03
	 *@Description TODO
	 */
}
