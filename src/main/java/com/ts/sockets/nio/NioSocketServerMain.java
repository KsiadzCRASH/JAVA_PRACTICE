package com.ts.sockets.nio;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.function.Predicate;
import com.ts.properties.PropertiesLoader;

public class NioSocketServerMain {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		NioSocketServer.NioServerStats serverStats = new NioSocketServer.NioServerStats();
		NioSocketServer nioSocketServer = new NioSocketServer(serverStats, Integer.valueOf(PropertiesLoader.INST.getValue("socket.host.port")));
		Executors.newSingleThreadExecutor().submit(nioSocketServer).get();

	}
}
