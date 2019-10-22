package com.ts.sockets.old;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.logging.Logger;
import org.reactivestreams.Subscriber;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

public class SocketClient implements Callable<Void> {

	private static volatile int clientCount = 0;
	private final UUID uuid;
	private final String hostName;
	private final int port;

	public SocketClient(String hostName, int port) {
		this.uuid = UUID.randomUUID();
		this.port = port;
		this.hostName = hostName;
	}


	@Override
	public Void call() throws Exception {
		Logger.getGlobal().info("Call ");
		try(
				Socket socket = new Socket(hostName, port);
				PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
				BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		){
			int cNr = ++clientCount;
			writer.println("["+cNr+"]This is client uid: " + uuid + " Who are you? :");
			String response = reader.readLine();
			Logger.getGlobal().info("["+cNr+"]Response : " + response);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
}
