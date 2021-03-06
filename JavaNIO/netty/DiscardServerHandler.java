package netty;

import io.netty.buffer.ByteBuf;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

public class DiscardServerHandler extends ChannelInboundHandlerAdapter {
	/**
	 * 每当从客户端接收新数据时，使用该方法接收客户端的消息
	 */
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		  ByteBuf in = (ByteBuf) msg;
		    try {
		        while (in.isReadable()) { // (1)
		            System.out.print((char) in.readByte());
		            System.out.flush();
		        }
		    } finally {
		        ReferenceCountUtil.release(msg); // (2)
		    }
		    // 或者直接打印
		    System.out.println("Yes, A new client in = " + ctx.name());
	}
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		cause.printStackTrace();
		ctx.close();
	}

}
