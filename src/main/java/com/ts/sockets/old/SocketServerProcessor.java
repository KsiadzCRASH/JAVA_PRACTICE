package com.ts.sockets.old;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.logging.Logger;
import io.reactivex.Observable;
import io.reactivex.Observer;

public class SocketServerProcessor implements Callable<Integer>{

	private static volatile int processorNumber = 0;

	private final Socket socket;
	private final UUID uuid;

	public SocketServerProcessor(Socket socket) {
		this.uuid = UUID.randomUUID();
		this.socket = socket;
	}

	@Override
	public Integer call() throws Exception {

		try (
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		) {
			int pNr = ++processorNumber;
			String msgFromTheDarkSide = in.readLine();
			Logger.getGlobal().info("["+pNr+"]Writing to stream: " + msgFromTheDarkSide + pNr + " PID: " + uuid + Thread.currentThread().getId());
			out.println(msgFromTheDarkSide + pNr + " PID: " + uuid);
			return pNr;
		}
	}
/*
	public void run() {

		try (
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(
						new InputStreamReader(
								socket.getInputStream()));
		) {
			String inputLine, outputLine;
			KnockKnockProtocol kkp = new KnockKnockProtocol();
			outputLine = kkp.processInput(null);
			out.println(outputLine);

			while ((inputLine = in.readLine()) != null) {
				outputLine = kkp.processInput(inputLine);
				out.println(outputLine);
				if (outputLine.equals("Bye"))
					break;
			}
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/
}
