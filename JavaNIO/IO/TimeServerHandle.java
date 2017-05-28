package IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

/**
 * TimeServerHandle实现了Runnable接口
 */
public class TimeServerHandle implements Runnable{
	
	private Socket socket;

	public TimeServerHandle(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//打开输入输出流
		BufferedReader in  = null;
		PrintWriter out = null;
		try {
			in = new BufferedReader(new InputStreamReader(
					this.socket.getInputStream()));
			out = new PrintWriter(this.socket.getOutputStream(),true);
			String currentTime = null;
			String body = null;
			while(true){
				//从输入流中读取一行数据
				body = in.readLine();
				if(body == null)
					break;
				System.out.println("ServerRun");

				System.out.println("The time server receive order : " + body);
				currentTime = "QUARY TIME ORDER".equalsIgnoreCase(body)?
						new Date(System.currentTimeMillis()).toString():"BAD ORDER";
				out.println(currentTime);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			if(in != null){
				try {
					in.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(out != null){
				out.close();
				out = null;
			}
			if(this.socket != null){
				try {
					this.socket.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				this.socket = null;
			}
		}
		
	}

}
