package Net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerDemo {
	public static void main(String[] args) throws IOException{
		
		ServerSocket socket = new ServerSocket(10002);
		System.out.println("�ȴ����ӣ�");
		Socket s = socket.accept();
		System.out.print("���ӳɹ���");
		String ip = s.getInetAddress().getHostAddress();
		BufferedReader in = new BufferedReader(
				new InputStreamReader(
						s.getInputStream()));
		Scanner scanner = new Scanner(in);
		System.out.println(ip+scanner.nextLine());
		socket.close();
		s.close();
	}

}
