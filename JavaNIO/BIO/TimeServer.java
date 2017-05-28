package BIO;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 同步阻塞式
 * 
 * @author 张志鹏
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
		//创建ServerSocket
		ServerSocket server = null;
		try {
			server = new ServerSocket(port);
			System.out.println("The time server is start in port :" + port);
			//创建Socket
			Socket socket = null;
			while (true) {
				//等待客户端连接
				socket = server.accept();
				System.out.println("Connected!");
				//连接成功，启动服务器线程
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