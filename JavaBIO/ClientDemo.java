package Net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;



public class ClientDemo {
	
	public static void main(String[]args) throws IOException{
		/*
		 * Tcp传输，客户端的建立
		 * 1.创建tcp客户端socket服务，使用的是socket对象
		 * 	建议该对象以创建就明确目的地，要连接的主机
		 *  2.如果连接创建成功，说明数据传输通道已建立
		 *  	该通道就是socket流，是底层建立好的
		 *       既有输入也有输出
		 *      	想要输 入或输出流对象，可以找socket获取
		 *  3.使用输出流，将数据写出
		 *      
		 */
//		创建客户端socket服务
		Socket socket = new Socket("127.0.0.1",10002);
//		获取socket流中的输出流
		OutputStream out =  socket.getOutputStream();
		BufferedReader buff = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out.write("我来了".getBytes());
		
		Scanner scanner = new Scanner(buff);
		System.out.println("服务器端："+scanner);
		
		
//		关闭资源
		socket.close();
		out.close();
		buff.close();
		
	}
		

}
