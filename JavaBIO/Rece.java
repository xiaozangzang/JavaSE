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

		// 创建数据包
		try {
			while (true) {
				byte[] buf = new byte[1024];
				DatagramPacket dp = new DatagramPacket(buf, buf.length);

				// 3.使用接收方法将数据存储到数据包中
				ds.receive(dp);// 阻塞式的；

				// 4.通过数据包对象的方法，解析其中的数据，比如地址、端口号、数据内容等
				String ip = dp.getAddress().getHostAddress();
				int port = dp.getPort();
				String text = new String(dp.getData(), 0, dp.getLength());

				System.out.println(ip + ":" + ":" + text);
				if (text.equals("886")) {
					System.out.print("退出聊天室！");
				}
			}
		} catch (Exception e) {

		}

	}

}
