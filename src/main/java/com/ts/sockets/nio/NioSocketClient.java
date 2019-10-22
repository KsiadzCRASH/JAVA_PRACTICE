package com.ts.sockets.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.logging.Logger;

public class NioSocketClient implements Callable<Void>{

	private final String hostName;
	private final int port;

	public NioSocketClient(String hostName, int port) {
		this.hostName = hostName;
		this.port = port;
	}

	@Override
	public Void call() throws Exception {

		try(
			AsynchronousSocketChannel client = AsynchronousSocketChannel.open()
		){
			Future<Void> channel = client.connect(new InetSocketAddress(hostName, port));
			channel.get();

			ByteBuffer comBuffer = ByteBuffer.wrap(("DUPA. T :" + Thread.currentThread().getId()).getBytes());
			client.write(comBuffer).get();
			comBuffer.clear();

			ByteBuffer readBuffer = ByteBuffer.allocate(4096);
			Thread.currentThread().sleep(500);
			client.read(readBuffer).get();

			Logger.getGlobal().info("Echo from server: " + new String(readBuffer.array()));
			readBuffer.clear();
		}
		return null;
	}
}
