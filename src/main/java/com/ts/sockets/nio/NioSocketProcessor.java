package com.ts.sockets.nio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.logging.Logger;

public class NioSocketProcessor implements CompletionHandler<Integer, Boolean> {


	final AsynchronousSocketChannel channel;

	public NioSocketProcessor(AsynchronousSocketChannel channel, ByteBuffer comBuffer) {
	//	this.comBuffer = comBuffer;
		this.channel = channel;
	}

	@Override
	public void completed(Integer result, Boolean flipper) {

			if(flipper){
				ByteBuffer comBuffer = ByteBuffer.wrap(("Server response; T: " + Thread.currentThread().getId()).getBytes());
				channel.write(comBuffer, flipper, this);
				comBuffer.clear();
			}else{

				flipper = Boolean.TRUE;
				ByteBuffer buffer = ByteBuffer.allocate(4096);

				channel.read(buffer, flipper, this);
			}
	}

	@Override
	public void failed(Throwable exc, Boolean attachment) {

	}
}
