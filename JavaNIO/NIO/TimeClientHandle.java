package NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class TimeClientHandle implements Runnable {

	private String host;

	private int port;

	private Selector selector;

	private SocketChannel socketChannel;

	private volatile boolean stop;

	public TimeClientHandle() {
		super();
	}

	public TimeClientHandle(String host, int port) {
		this.host = host == null ? "127.0.0.1" : host;
		this.port = port;
		System.out.println(port);
		try {
			selector = Selector.open();
			//打开socketChannel
			socketChannel = SocketChannel.open();
			//设置socketChannel为非阻塞模式
			socketChannel.configureBlocking(false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			doConnect();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		//多路复用器轮询准备就绪的Key
		while (!stop) {
			try {
				selector.select(1000);
				Set<SelectionKey> selectedKeys = selector.selectedKeys();
				Iterator<SelectionKey> it = selectedKeys.iterator();
				SelectionKey key = null;
				while (it.hasNext()) {
					key = it.next();
					it.remove();
					try {
						handleInput(key);
					} catch (Exception e) {
						if (key != null) {
							key.cancel();
							if (key.channel() != null)
								key.channel().close();
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
		if(selector != null)
			try{
				selector.close();
			}catch(IOException e){
				e.printStackTrace();
			}
	}

	private void handleInput(SelectionKey key) throws IOException {
		// TODO Auto-generated method stub
		if(key.isValid()){
			SocketChannel sc = (SocketChannel) key.channel();
			if(key.isConnectable()){
				if(sc.finishConnect()){
					sc.register(selector, SelectionKey.OP_READ);
					doWrite(sc);
				}else
					System.exit(1);//连接失败，进程退出
			}
			if(key.isReadable()){
				ByteBuffer readBuffer = ByteBuffer.allocate(1024);
				int readBytes = sc.read(readBuffer);
				if(readBytes > 0){
					readBuffer.flip();
					byte[] bytes = new byte[readBuffer.remaining()];
					readBuffer.get(bytes);
					String body = new String(bytes,"UTF-8");
					System.out.println("Now is : " + body);
					this.stop = true;
				}else if(readBytes < 0){
					//对端链路关闭
					key.cancel();
					sc.close();
				}else
					;
			}
		}
	}

	private void doWrite(SocketChannel sc) throws IOException {
		// TODO Auto-generated method stub
		byte[] req = "QUERY TIME ORDER".getBytes();
		ByteBuffer writeBuffer = ByteBuffer.allocate(req.length);
		writeBuffer.put(req);
		writeBuffer.flip();
		sc.write(writeBuffer);
		if(!writeBuffer.hasRemaining())
			System.out.println("Send order 2 server succeed.");
	}

	private void doConnect() throws IOException{
		// TODO Auto-generated method stub
		//异步连接到服务端，并且直接注册读状态位到多路复用器中。
		if(socketChannel.connect(new InetSocketAddress(host,port))){
			socketChannel.register(selector, SelectionKey.OP_READ);
			doWrite(socketChannel);
		}else
			socketChannel.register(selector, SelectionKey.OP_CONNECT);

	}

}











