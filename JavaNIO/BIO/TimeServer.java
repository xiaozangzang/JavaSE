package BIO;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ͬ������ʽ
 * 
 * @author ��־��
 * 
 */

public class TimeServer {
	public static void main(String[] args) throws IOException {
		int port = 8080;
		if (args != null && args.length > 0) {
			try {
				port = Integer.valueOf(args[0]);

			} catch (NumberFormatException e) {

			}
		}
		//����ServerSocket
		ServerSocket server = null;
		try {
			server = new ServerSocket(port);
			System.out.println("The time server is start in port :" + port);
			//����Socket
			Socket socket = null;
			while (true) {
				//�ȴ��ͻ�������
				socket = server.accept();
				System.out.println("Connected!");
				//���ӳɹ��������������߳�
				new Thread(new TimeServerHandle(socket)).start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (server != null) {
				System.out.println("The time server close");
				server.close();
				server = null;
			}
		}
	}

}