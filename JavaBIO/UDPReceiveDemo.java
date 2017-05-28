package Net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPReceiveDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("���ն�����...");
		/*
		 * ����UDP���ն˵�˼·
		 * 1.����udp socket����    ��Ϊ��Ҫ�������ݣ�����Ҫ��ȷһ���˿ں�
		 * 2.�������ݰ�   �����洢���յ��Ķ����ݣ����������ݰ�����ķ���������Щ����
		 * 3.ʹ��socket�����receive���������ܵ������ݴ洢�����ݰ�
		 * 4.ͨ�����ݰ��ķ����������ݰ��е�����
		 */
//		1.����  udp  socket����
	
		DatagramSocket ds = new DatagramSocket(10000);
		//�������ݰ�
		byte[] buf = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buf, buf.length);
		  
		//3.ʹ�ý��շ��������ݴ洢�����ݰ���
		ds.receive(dp);//����ʽ�ģ�
		
		//4.ͨ�����ݰ�����ķ������������е����ݣ������ַ���˿ںš��������ݵ�
		String ip = dp.getAddress().getHostAddress();
		int port = dp.getPort();
		String text = new String(dp.getData(),0,dp.getLength());
		 System.out.println(ip + ":" + ":"+ text);
		 
		 //�ر���Դ
		 ds.close();

	}

}
