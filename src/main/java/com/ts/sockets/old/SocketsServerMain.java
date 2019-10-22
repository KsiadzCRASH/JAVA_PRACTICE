package com.ts.sockets.old;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Logger;
import com.ts.properties.PropertiesLoader;

public class SocketsServerMain {



	public static void main(String[] args) throws ExecutionException, InterruptedException {

		SocketServer server = new SocketServer(
				socket -> new SocketServerProcessor(socket),
				serverStats -> serverStats.servedClientCount < 1000,
				Executors.newScheduledThreadPool(20),
				Integer.valueOf(PropertiesLoader.INST.getValue("socket.host.port")));

		Future<SocketServer.ServerStats> statsFuture = Executors.newSingleThreadExecutor().submit(server);

		while (!statsFuture.isDone()){
			Thread.sleep(200);
		}
		Logger.getGlobal().info("Processed RQ's : " + statsFuture.get().servedClientCount);
	}
}
