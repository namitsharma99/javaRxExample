package javaRxExample.sampleCode;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class MyObservable3 {

	private static long start = System.currentTimeMillis();

	public static Boolean isSlowTime() {
		return (System.currentTimeMillis() - start) % 30000 >= 15000;
	}

	public static void main(String[] args) {

		Observable<Long> fast = Observable.interval(1, TimeUnit.SECONDS);
		Observable<Long> slow = Observable.interval(3, TimeUnit.SECONDS);

		Observable<Long> clock = Observable.merge(
				slow.filter(tick -> isSlowTime()),
				fast.filter(tick -> !isSlowTime()));

		clock.subscribe(tick -> System.out.println(new Date()));

		try {
			Thread.sleep(60000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
