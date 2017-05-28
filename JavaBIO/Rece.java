package Net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Rece implements Runnable {

	private DatagramSocket ds;

	public Rece(DatagramSocket ds) {
		this.ds = ds;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		// �������ݰ�
		try {
			while (true) {
				byte[] buf = new byte[1024];
				DatagramPacket dp = new DatagramPacket(buf, buf.length);

				// 3.ʹ�ý��շ��������ݴ洢�����ݰ���
				ds.receive(dp);// ����ʽ�ģ�

				// 4.ͨ�����ݰ�����ķ������������е����ݣ������ַ���˿ںš��������ݵ�
				String ip = dp.getAddress().getHostAddress();
				int port = dp.getPort();
				String text = new String(dp.getData(), 0, dp.getLength());

				System.out.println(ip + ":" + ":" + text);
				if (text.equals("886")) {
					System.out.print("�˳������ң�");
				}
			}
		} catch (Exception e) {

		}

	}

}
