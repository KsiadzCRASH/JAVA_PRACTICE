package com.ts.paszczak;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;


import static java.lang.System.currentTimeMillis;

class MessageThrottlingTest {

	interface TestTime{
		long test(int iterationCount, String input);
	}

	class CharAt implements TestTime{

		@Override
		public long test(int iterationCount, String input) {
			long start = currentTimeMillis();
			for (int i = 0; i < iterationCount; i++) {
				if (testCharAt(input)) return 0;
			}

			return currentTimeMillis() - start;
		}

		private boolean testCharAt(String input) {
			for (int i = 0; i < input.length(); i++) {
				char aa = input.charAt(i);
				if(aa == 'b') return true;
			}
			return false;
		}
	}

	class CopyArray implements TestTime{

		@Override
		public long test(int iterationCount, String input) {
			long start = currentTimeMillis();
			for (int i = 0; i < iterationCount; i++) {
				if (testCopyArray(input)) return 0;
			}
			return currentTimeMillis() - start;
		}

		private boolean testCopyArray(String input) {
			char[] table = new char[input.length()];
			input.getChars(0, input.length(), table, 0);
			for (int i = 0; i < table.length; i++) {
				if(table[i] == 'b') return true;
			}
			return false;
		}
	}


	@Test
	void testIterateOverCopy(){

		int iterationCount = 100000;
		String testStr= createStrWithLen(5);
		long charAt = 0;
		long copyArray = 0;
		for (int i=0; i < iterationCount; i++) {

			charAt += new CharAt().test(iterationCount, testStr);
			copyArray += new CopyArray().test(iterationCount, testStr);
		}
		Logger.getGlobal().info("CharAt: " + charAt);
		Logger.getGlobal().info("ArrayCopy: " + copyArray);

	}

	private String createStrWithLen(int i) {
		StringBuilder buffer = new StringBuilder();
		for (int j = 0; j < i; j++) {
			buffer.append("D");
		}
		return buffer.toString();
	}


	@Test
	void testThrottling() throws InterruptedException {

		final MessageThrottling.MessageThrottler messageThrottler = new MessageThrottling.MessageThrottler();
		messageThrottler.sourceTypes = Arrays.asList(new MessageThrottling.ThrottlingDef("DUPA".toCharArray(), 500, 1000));

		final MessageThrottling.Message valid  = new MessageThrottling.Message("DU", "PA", "Some payload");
		final MessageThrottling.Message invalid  = new MessageThrottling.Message("DU", "ZZ", "Some payload");

		Collection<Callable<Void>> callableList = IntStream.range(0, 1500600).mapToObj(val -> new Callable<Void>(){
			@Override
			public Void call() throws InterruptedException {
				messageThrottler.throttle(valid);
				//ogger.getGlobal().info("Valid MSG: " + );
				//Thread.sleep(50);
				//gger.getGlobal().info("Invalid MSG: " + messageThrottler.throttle(invalid));
				return null;
			}
		}).collect(Collectors.toList());

		Executors.newFixedThreadPool(1).invokeAll(callableList);


		//Thread.sleep(2000);

		Logger.getGlobal().info("Rejected: " + messageThrottler.rejected + " Accepted: " + messageThrottler.accepted);
	}

}