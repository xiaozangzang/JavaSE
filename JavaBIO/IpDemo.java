package Net;

import java.net.InetAddress;
import java.net.UnknownHostException;


public class IpDemo {

	/**
	 * @param args
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException {
		// TODO Auto-generated method stub
		//获取本地主机,创建IP对象
		InetAddress ip = InetAddress.getLocalHost();
//		ip = InetAddress.getByName("xiaozangzang");
//		ip= InetAddress.getByName("192.168.43.20");
		ip= InetAddress.getByName("www.baidu.com");
		System.out.println(ip.getHostAddress());
		System.out.println(ip.getHostName());
		
	}

}
