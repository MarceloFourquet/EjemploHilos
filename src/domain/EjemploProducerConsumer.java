
package domain;

import model.Processor;

public class EjemploProducerConsumer{

	public static void main(String[] args){
		
		final Processor processor = new Processor();
		
		Thread t1 = new Thread(() -> {
			try{
				processor.produce();
			}catch(InterruptedException ex){
			}
		});
		
		Thread t2 = new Thread(() -> {
			try{
				processor.consume();
			}catch(InterruptedException ex){
			}
		});
		
		t1.start();
		t2.start();
	}

}
