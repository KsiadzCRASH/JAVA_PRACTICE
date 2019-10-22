package com.ts.sockets.old;

import java.net.Socket;
import java.util.concurrent.Callable;

public abstract class AbstractServerProcessorFactory {
	public abstract Callable<Integer> build(Socket socket);
}
