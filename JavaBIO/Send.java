package Net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Send implements Runnable {

	private DatagramSocket ds;

	public Send(DatagramSocket ds) {
		this.ds = ds;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			BufferedReader buff = new BufferedReader(new InputStreamReader(
					System.in));
			String line = null;

			while ((line = buff.readLine()) != null) {

				byte[] buf = line.getBytes();
				// 使用DatagramPacket将数据封装到该对象中
				DatagramPacket dp = new DatagramPacket(buf, buf.length,
						InetAddress.getByName("127.0.0.1"), 10001);
				// 3.通过udp的socket服务将数据包发送出去，使用send方法
				if ("886".equals(line))
					break;
			}
			ds.close();
		} catch (Exception e) {

		}

	}

}
