package IO;
/**
 * ͬ������ʽģ�ͣ��������̳߳غ���Ϣ����ʵ��
 */
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class TimeSever {
	public static void main(String[] args) throws IOException{
		int port = 8080;
		if(args != null && args.length > 0){
			try{
				port = Integer.valueOf(args[0]);
			}catch(NumberFormatException e){
				
			}
		}
		ServerSocket server = null;
		try{
			server = new ServerSocket(port);
			System.out.println("The time server is start in port : " + port);
			Socket socket = null;
			//�����̳߳�
			TimeServerHandleExcutePool singleExcutor = 
				new TimeServerHandleExcutePool(50,10000);
			while(true){
				socket = server.accept();
				//���ͻ��˵�socket��װ��һ��Task�����̳߳���
				singleExcutor.excute(new TimeServerHandle(socket));
			}
		}finally{
			if(server != null){
				System.out.println("The time server close.");
				server.close();
				server = null;
			}
		}
	}

}
