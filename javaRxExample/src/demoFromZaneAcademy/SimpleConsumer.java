package demoFromZaneAcademy;

import io.reactivex.functions.Consumer;

public class SimpleConsumer implements Consumer<String> {

	@Override
	public void accept(String arg0) throws Exception {
		System.out.println("Hello from the consumer: "+ arg0);
	}

}
