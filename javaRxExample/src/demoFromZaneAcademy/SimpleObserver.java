package demoFromZaneAcademy;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class SimpleObserver implements Observer<String> {

	@Override
	public void onComplete() {
		System.out.println("Completed!");		
	}

	@Override
	public void onError(Throwable arg0) {
		System.out.println("Error...");		
	}

	@Override
	public void onNext(String arg0) {
		System.out.println("Next: "+arg0);
	}

	@Override
	public void onSubscribe(Disposable arg0) {
		// TODO Auto-generated method stub		
	}

	
}
