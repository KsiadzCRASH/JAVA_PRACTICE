package com.ts.paszczak;

import java.util.List;

public class MessageThrottling {

	public static class ThrottlingDef {
		final char[] patternArray;
		final long timeWindow;
		final int msgLimit;
		final MessageAccumulator accumulator;

		public ThrottlingDef(char[] patternArray, long timeWindow, int msgLimit) {
			this.patternArray = patternArray;
			this.timeWindow = timeWindow;
			this.msgLimit = msgLimit;

			this.accumulator = new MessageAccumulator();
		}

		public boolean accept(Message message){
			// sourceType
			if (message.getSource() != null && message.getType() != null){
				int sourceLen;
				if(patternArray.length == (sourceLen = message.getSource().length()) + message.getType().length()){
					for (int i = 0; i < patternArray.length; i++) {
						if(i < sourceLen){
							if(patternArray[i] != message.getSource().charAt(i)) return false;
						}else {
							if(patternArray[i] != message.getType().charAt(i - sourceLen)) return false;
						}
					}
					return true;
				}
				return false;
			}else if(message.getSource() != null){
				//....
			}else if (message.getType() != null){
				//....
			}

			// source

			// type


			return false;
		}

		class MessageAccumulator {

			private volatile int counter = 0;
			private volatile long start = -1;

			boolean tyrAccumulate(){
				synchronized (this) {
					long storeTime = System.currentTimeMillis();
					if(start == -1) start = storeTime;
					long period = storeTime - start;

					counter++;

					if(period <= timeWindow) {
						return counter <= msgLimit;
					}else {
						start = storeTime;
						counter = 1;

						if(counter > msgLimit){ //if msgLimit == 0
							return false;
						}

						return true;
					}
				}
			}

		}
	}


	static class Message {
		private final String source;
		private final String type;
		private final String payload;

		public Message(String source, String type, String payload) {
			this.source = source;
			this.type = type;
			this.payload = payload;
		}

		public String getSource() {
			return source;
		}

		public String getType() {
			return type;
		}

		public String getPayload() {
			return payload;
		}
	}

	public static class MessageThrottler  {

		public List<ThrottlingDef> sourceTypes;

		public volatile int rejected = 0;
		public volatile int accepted = 0;

		boolean throttle(Message msg){

			for (ThrottlingDef def : sourceTypes){
				if(def.accept(msg)){
					if(def.accumulator.tyrAccumulate()){
						accepted++;
						return true;
					}else{
						rejected++;
						return false;
					}
				}
			}
			return true;
		}
	}
}




