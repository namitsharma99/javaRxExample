package javaRxExample.sampleCode;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class MyObservable {

	/**
	 * -- io.reactivex.Flowable : 0..N flows, supporting Reactive-Streams and backpressure 
	 * -- io.reactivex.Observable: 0..N flows, no backpressure
	 * -- io.reactivex.Single: a flow of exactly 1 item or an error
	 * -- io.reactivex.Completable: a flow without items but only a completion or error signal 
	 * -- io.reactivex.Maybe: a flow with no items, exactly one item or an error
	 * 
	 */

	public static void main(String[] args) {

		
		// 1.	creating a flowable using simple hello world example
		Consumer<String> consumer = new Consumer<String>() {
			@Override
			public void accept(String arg0) throws Exception {
				System.out.println(arg0);
			}
		};
		Flowable.just("Hello World").subscribe(consumer);
		
		///////////////////////////////////////////////////////////////////////////////////////////
		
		
		// 2. creating an observable from existing data structure
		
		Observable<String> o1 = Observable.fromArray("a", "b", "c");
		// Observable<Integer> o2 = Observable.fromArray(1, 2, 3);
		// Observable<String> o3 = Observable.just("Hello...");
		
		Consumer<String> consumer1 = new Consumer<String>() {
			@Override
			public void accept(String arg0) throws Exception {
				System.out.println("bye bye "+arg0);	
			}
		};
		o1.subscribe(consumer1);
		
		////////////////////////////////////////////////////////////////////////////////////////////
		
		
		// 3. The other way to create Observables is by calling the create method and implementing your own logic to call onNext, onError and onCompleted
		
		
		
		
		
		
	}

}
