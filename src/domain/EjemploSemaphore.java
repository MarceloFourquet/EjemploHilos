
package domain;

import java.util.concurrent.*;
import model.Connection;

public class EjemploSemaphore{

	public static void main(String[] args){
		
		ExecutorService executor = Executors.newCachedThreadPool();
		
		for(int i = 0; i < 200; i++){
			executor.submit(() -> {
				Connection.getInstance().connect();
			});
		}
		
		executor.shutdown();
		try{
			executor.awaitTermination(1, TimeUnit.MINUTES);
		}catch(InterruptedException ex){
			System.out.println(ex.getMessage());
		}
	}
	
}
