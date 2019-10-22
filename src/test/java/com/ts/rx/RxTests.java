package com.ts.rx;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import com.sun.media.jfxmediaimpl.MediaDisposer;
import io.reactivex.Emitter;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.schedulers.ComputationScheduler;
import io.reactivex.internal.schedulers.NewThreadScheduler;

public class RxTests {

	@Test
	public void simpleRxFlowRR() {


		ThreadPoolExecutor tp = new ThreadPoolExecutor(1,
				5, 60, TimeUnit.SECONDS,
				new LinkedBlockingQueue<Runnable>(50000));

		for(int i = 10; i < 1000; i ++){

		//	tp.

		}


	}

		@Test
	public void simpleRxFlow(){


		Observable<String> source = Observable.generate(new Consumer<Emitter<String>>() {

			int val = 0;
			@Override
			public void accept(Emitter<String> stringEmitter) throws Exception {
				stringEmitter.onNext(Thread.currentThread().getId() + " emitted value " + val++) ;
			}
		});

		Consumer<String> stringSubscriber = new Consumer<String>() {

			@Override
			public void accept(String s) throws Exception {
				Logger.getGlobal().info("On accept: " + s + "Print on THREAD: " + Thread.currentThread().getId());
			}
		};



		Disposable disposable = source.subscribe(stringSubscriber);
	}


}
