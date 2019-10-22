package com.ts.jmh;

import java.io.IOException;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.RunnerException;

@State(Scope.Benchmark)
@Warmup(iterations = 2)
@BenchmarkMode(Mode.All)
public class Volatile {

	public static void main(String[] args) throws IOException, RunnerException {
		org.openjdk.jmh.Main.main(args);
	}

	private int atr;
	private static int staticAtr;
	private volatile int volatileAtr;
	private static volatile int staticVolatileAtr;


	final int val  = 1;
	final int compareVal = Integer.MAX_VALUE;
	final int warmup = 1;

	@Benchmark
	@Fork(value = val, warmups = warmup)
	public void readWriteAtr(){
		for(int i=0; i<compareVal; i++){
			if(atr < compareVal){
				atr++;
			}
		}
	}
	@Benchmark
	@Fork(value = val, warmups = warmup)
	public void readWriteStaticVolatileAtr(){
		for(int i=0; i<compareVal; i++) {
			if (staticVolatileAtr < compareVal) {
				staticVolatileAtr++;
			}
		}
	}
	@Benchmark
	@Fork(value = val, warmups = warmup)
	public void readWriteStaticAtr(){
		for(int i=0; i<compareVal; i++) {
			if (staticAtr < compareVal) {
				staticAtr++;
			}
		}
	}
	@Benchmark
	@Fork(value = val, warmups = warmup)
	public void readWriteVolatileAtr(){
		for(int i=0; i<compareVal; i++){
			if(volatileAtr < compareVal){
				volatileAtr++;
			}
		}
	}

}
