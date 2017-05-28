package Net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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


public class UDPSendDemo2 {

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
		BufferedReader buff = new BufferedReader(
				new InputStreamReader(System.in));
		String line = null;
		
		while((line = buff.readLine())!=null){
			
			byte[] buf = line.getBytes();
		//使用DatagramPacket将数据封装到该对象中
		DatagramPacket dp = new DatagramPacket(
				buf, buf.length,InetAddress.getByName("127.0.0.1"),10000);
		//3.通过udp的socket服务将数据包发送出去，使用send方法
		if("886".equals(line))
				break;
		ds.send(dp);
		}
		ds.close();
	}

}
