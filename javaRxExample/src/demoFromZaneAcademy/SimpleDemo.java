package demoFromZaneAcademy;

import io.reactivex.Observable;

public class SimpleDemo {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {

		// List<String> shapeList = Arrays.asList("rectange", "square",
		// "circle");
		Observable observableString = Observable.fromArray("rectange",
				"square", "circle");

		SimpleObserver simpleObserver = new SimpleObserver();
		observableString.subscribe(simpleObserver);
	}

}
