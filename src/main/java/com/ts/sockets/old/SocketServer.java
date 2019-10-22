package com.ts.sockets.old;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.logging.Logger;

public class SocketServer implements Callable<SocketServer.ServerStats>{

	private final int serverPort;
	private final Predicate<ServerStats> shouldLiten;
	private final Function<Socket, Callable<Integer>> processorFactory;
	private final ExecutorService executorService;

	public SocketServer(Function<Socket, Callable<Integer>> processorFactory, Predicate<ServerStats> stopCondition, ExecutorService executorService, int serverPort){
		this.serverPort = serverPort;
		this.processorFactory = processorFactory;
		this.shouldLiten = stopCondition;
		this.executorService = executorService;
	}

	@Override
	public ServerStats call() throws Exception {
		Logger.getGlobal().info("I'm inside");
		final ServerStats serverStats = new ServerStats();
		try(ServerSocket serverSocket = new ServerSocket(serverPort)){
			while (shouldLiten.test(serverStats)){
				Socket socket = serverSocket.accept();
				serverStats.servedClientCount++;
				Logger.getGlobal().info(socket.toString());
				Future<Integer> future = executorService.submit(processorFactory.apply(socket));
				Logger.getGlobal().info("Processor ended job. PNR: " + future.get()); // blocker ???
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return serverStats;
	}

	static class ServerStats{
		int servedClientCount = 0;

		public int getServedClientCount() {
			return servedClientCount;
		}
	}
}
