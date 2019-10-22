package com.ts.sockets.old;

import com.ts.properties.PropertiesLoader;

public class SocketClientFactory {

	public static final SocketClientFactory INST = new SocketClientFactory();

	public SocketClient build(){
		return new SocketClient(PropertiesLoader.INST.getValue("socket.host.name"), Integer.valueOf(PropertiesLoader.INST.getValue("socket.host.port")));
	}
}
