package Net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
/*
 * ����UDP����ķ��Ͷ�
 * ˼·��
 * 1.����udp��socket�ķ���
 * 2.��Ҫ���͵����ݷ�װ�����ݰ�
 * 3.ͨ��udp��socket�������ݰ��ͳ�ȥ
 * 4.�ر�socket����
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
		System.out.println("���Ͷ�����...");
//		1.upsocket����    ʹ��DatagramSocket����
		DatagramSocket ds = new DatagramSocket();
		//2.��Ҫ���͵����ݷ�װ�����ݰ���
		String str = "��ඣ�������";
		//ʹ��DatagramPacket�����ݷ�װ���ö�����
		byte[] buf = str.getBytes();
		DatagramPacket dp = new DatagramPacket(
				buf, buf.length,InetAddress.getByName("127.0.0.1"),10000);
		//3.ͨ��udp��socket�������ݰ����ͳ�ȥ��ʹ��send����
		ds.send(dp);
		ds.close();
	}

}
