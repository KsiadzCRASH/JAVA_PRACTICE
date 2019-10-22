package com.ts.sockets.old;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SocketsClientMain {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = Executors.newScheduledThreadPool(10);
		executorService.invokeAll(generateClients(1000));

		Thread.sleep(10000);
	}

	private static List<Callable<Void>> generateClients(int taskCount) {
		return IntStream.range(0, taskCount)
				.mapToObj(x -> SocketClientFactory.INST.build())
				.collect(Collectors.toList());
	}
}
