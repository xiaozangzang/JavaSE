package Net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;



public class ClientDemo {
	
	public static void main(String[]args) throws IOException{
		/*
		 * Tcp���䣬�ͻ��˵Ľ���
		 * 1.����tcp�ͻ���socket����ʹ�õ���socket����
		 * 	����ö����Դ�������ȷĿ�ĵأ�Ҫ���ӵ�����
		 *  2.������Ӵ����ɹ���˵�����ݴ���ͨ���ѽ���
		 *  	��ͨ������socket�����ǵײ㽨���õ�
		 *       ��������Ҳ�����
		 *      	��Ҫ�� �����������󣬿�����socket��ȡ
		 *  3.ʹ���������������д��
		 *      
		 */
//		�����ͻ���socket����
		Socket socket = new Socket("127.0.0.1",10002);
//		��ȡsocket���е������
		OutputStream out =  socket.getOutputStream();
		BufferedReader buff = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out.write("������".getBytes());
		
		Scanner scanner = new Scanner(buff);
		System.out.println("�������ˣ�"+scanner);
		
		
//		�ر���Դ
		socket.close();
		out.close();
		buff.close();
		
	}
		

}
