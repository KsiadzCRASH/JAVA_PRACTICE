package com.ts.sockets.nio;

import com.ts.properties.PropertiesLoader;

public class NioSocketClientFactory {

	public static final NioSocketClientFactory INST = new NioSocketClientFactory();

	public NioSocketClient build(){
		return new NioSocketClient(PropertiesLoader.INST.getValue("socket.host.name"), Integer.valueOf(PropertiesLoader.INST.getValue("socket.host.port")));
	}
}
