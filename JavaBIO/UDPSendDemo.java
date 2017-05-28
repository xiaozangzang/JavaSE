package Net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
/*
 * 创建UDP传输的发送端
 * 思路：
 * 1.建立udp的socket的服务
 * 2.将要发送的数据封装到数据包
 * 3.通过udp的socket服务将数据包送出去
 * 4.关闭socket服务
 * 
 */
import java.net.SocketException;


public class UDPSendDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stu
		System.out.println("发送端启动...");
//		1.upsocket服务    使用DatagramSocket对象
		DatagramSocket ds = new DatagramSocket();
		//2.将要发送的数据封装到数据包中
		String str = "哈喽，我来了";
		//使用DatagramPacket将数据封装到该对象中
		byte[] buf = str.getBytes();
		DatagramPacket dp = new DatagramPacket(
				buf, buf.length,InetAddress.getByName("127.0.0.1"),10000);
		//3.通过udp的socket服务将数据包发送出去，使用send方法
		ds.send(dp);
		ds.close();
	}

}
