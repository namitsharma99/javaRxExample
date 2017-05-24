package javaRxExample.sampleCode;

import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class MyObservable2 {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		// -----------------------------------------------------------------------------------------

		
		Consumer<String> consumer1 = new Consumer<String>() {
			@Override
			public void accept(String arg0) throws Exception {
				System.out.println("From consumer1 -> " + arg0);
			}
		};
		
		Observable<String> hello = Observable.just("Hello", "Hi");
		hello.subscribe(consumer1);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		// --------------------------------------------------------------------
		
		
		Consumer<List> consumer2 = new Consumer<List>() {
			@Override
			public void accept(List ls) throws Exception {
				for (Object obj : ls) {
					System.out.println("From consumer2 -> " + obj.toString());					
				}
			}
		};
		List<String> words = Arrays.asList(
				 "the",
				 "quick",
				 "brown",
				 "fox",
				 "jumped",
				 "over",
				 "the",
				 "lazy",
				 "dogs"
				);
		Observable<List> wordsObservable = Observable.just(words);
		// Observable<List> wordsObservable = Observable.just(words);    // need to check why it is giving error
		wordsObservable.subscribe(consumer2);
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		Observable newObservable = Observable.fromArray(words.toArray());
		Observable<Integer> rangeObservable = Observable.range(1, Integer.MAX_VALUE);
		// using in-line BiFunction
		Observable zippedObservable = newObservable.zipWith(rangeObservable, (string, count) -> String.format("%2d. %s", count, string));
		zippedObservable.subscribe(consumer1);
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		// some more modifications
		newObservable = Observable.fromArray(words.toArray());
		rangeObservable = Observable.range(1, Integer.MAX_VALUE);
		// using in-line BiFunction
		newObservable = newObservable.flatMap(word -> Observable.fromArray(((String) word).split("")));
		zippedObservable = newObservable.zipWith(rangeObservable, (string, count) -> String.format("%2d. %s", count, string));
		zippedObservable.subscribe(consumer1);
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		// let's sort the 26 letters now
		newObservable = Observable.fromArray(words.toArray());
		rangeObservable = Observable.range(1, Integer.MAX_VALUE);
		// using in-line sorting
		newObservable = newObservable.flatMap(word -> Observable.fromArray(((String) word).split(""))).distinct().sorted();
		zippedObservable = newObservable.zipWith(rangeObservable, (string, count) -> String.format("%2d. %s", count, string));
		zippedObservable.subscribe(consumer1);
		
	}

}
