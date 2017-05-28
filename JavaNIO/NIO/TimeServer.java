package NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

import javax.swing.plaf.multi.MultiPanelUI;

public class TimeServer {
	public static void main(String[] args) {
		int port = 8080;
		if(args != null && args.length > 0){
			try{
				port = Integer.valueOf(args[0]);
			} catch (NumberFormatException e){
				
			}
			
		}
		MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);
		new Thread(timeServer,"NIO-MultiplexerTimeServer-001").start();
	}

}


class MultiplexerTimeServer implements Runnable{
	
	private Selector selector;
	
	private ServerSocketChannel servChannel;
	
	private volatile boolean stop;
	/**
	 * 初始化多路复用器，绑定监听端口
	 */
	public MultiplexerTimeServer(){
		
	}
	public MultiplexerTimeServer(int port){
		try {
			//创建多路复用器
			selector = Selector.open();
			//打开ServerSocketChannel，用户监听客户端的连接，管道
			servChannel = ServerSocketChannel.open();
			//设置连接为非阻塞模式
			servChannel.configureBlocking(false);
			//绑定监听接口
			servChannel.socket().bind(new InetSocketAddress(port),1024);
			//将Channel注册到Selector上，监听ACCEPT事件
			servChannel.register(selector, SelectionKey.OP_ACCEPT);
			System.out.println("The time server is start in port " + port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void stop(){
		this.stop = true;
	}
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//循环遍历selector，休眠时间为1s
		while(!stop){
			try {
				//每隔1s被唤醒
				selector.select(1000);
				Set<SelectionKey> selectedKeys = selector.selectedKeys();
				Iterator<SelectionKey> it = selectedKeys.iterator();
				SelectionKey key = null;
				while(it.hasNext()){
					key = it.next();
					it.remove();
					try{
						handleInput(key);
					}catch(Exception e){
						if(key != null){
							key.cancel();
							if(key.channel() != null)
								key.channel().close();
						}
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//多路复用器关闭后，所有注册在上面的Channel和Pipe等资源都会被自动去注册不需要重复释放资源
		if(selector != null)
			try{
			selector.close();
			}catch(IOException e){
				e.printStackTrace();
			}
	}
	private void handleInput(SelectionKey key) throws IOException{
		//处理新接入的请求消息
		if(key.isValid()){
			//接受新的连接
			if(key.isAcceptable()){
				ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
				SocketChannel sc = ssc.accept();
				sc.configureBlocking(false);
				System.out.println("Connected!");
				//注册新的连接
				sc.register(selector, SelectionKey.OP_READ);
			}
			//读数据
			if(key.isReadable()){
				SocketChannel sc = (SocketChannel) key.channel();
				ByteBuffer readBuffer = ByteBuffer.allocate(1024);
				int readBytes = sc.read(readBuffer);
				if(readBytes > 0){
					readBuffer.flip();
					byte[] bytes = new byte[readBuffer.remaining()];
					readBuffer.get(bytes);
					String body = new String(bytes,"UTF-8");
					System.out.println("The time server receive order " + body);
					String currentTime = "QUERY TIME ORDER"
						.equalsIgnoreCase(body) ? new java.util.Date(
								System.currentTimeMillis()).toString():"BAD ORDER";
					doWrite(sc,currentTime);
				}else if(readBytes < 0)
					//对端链路关闭
					key.cancel();
				sc.close();
			}else
				;//读到0字节，忽略
		}
	}
	private void doWrite(SocketChannel channel, String response) throws IOException {
		// TODO Auto-generated method stub
		if(response != null && response.trim().length() > 0){
			byte[] bytes = response.getBytes();
			ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
			writeBuffer.put(bytes);
			writeBuffer.flip();
			channel.write(writeBuffer);
		}
	}
}










