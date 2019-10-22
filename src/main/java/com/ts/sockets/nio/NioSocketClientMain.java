package com.ts.sockets.nio;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NioSocketClientMain {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
	//	Executors.newSingleThreadExecutor().submit(NioSocketClientFactory.INST.build());
		Executors.newSingleThreadExecutor().submit(NioSocketClientFactory.INST.build()).get();

	}
}
