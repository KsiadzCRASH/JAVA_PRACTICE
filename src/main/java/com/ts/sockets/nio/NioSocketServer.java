package com.ts.sockets.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.logging.Logger;

public class NioSocketServer implements Runnable{

	private final NioServerStats serverStats;
	private final int serverPort;

	public NioSocketServer(NioServerStats serverStats, int serverPort) {
		this.serverPort = serverPort;
		this.serverStats = serverStats;
	}

	@Override
	public void run() {

		try(
				AsynchronousServerSocketChannel channel = AsynchronousServerSocketChannel
				.open()
				.bind(new InetSocketAddress(serverPort))
		)
		{
			Predicate<NioSocketServer.NioServerStats> stopCondition = s -> s.connectionsCount < 1000;

			while (stopCondition.test(serverStats)) {

				channel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Void>() {

					UUID uuid = UUID.randomUUID();

					@Override
					public void completed(AsynchronousSocketChannel clientChanel, Void attachment) {
						Logger.getGlobal().info("Entering handler: " + uuid + " T: " + Thread.currentThread());
						if (channel.isOpen()) {
							Logger.getGlobal().info("Accepting new connection: " + " T: " + Thread.currentThread());
							channel.accept(null, this);
						}

						if (clientChanel != null && clientChanel.isOpen()) {
							Logger.getGlobal().info("Connection is opened: " + " T: " + Thread.currentThread());
							serverStats.connectionsCount++;
							ByteBuffer comBuffer = ByteBuffer.allocate(4096);
							Boolean flipper = Boolean.TRUE;
							NioSocketProcessor nioSocketProcessor = new NioSocketProcessor(clientChanel, comBuffer);


							clientChanel.read(comBuffer,30, TimeUnit.SECONDS, flipper, nioSocketProcessor);
						}
					}

					@Override
					public void failed(Throwable exc, Void attachment) {
						Logger.getGlobal().severe(exc.getMessage());
					}
				});

				Thread.sleep(20000);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	static class NioServerStats {
		public int connectionsCount = 0;
	}
}
