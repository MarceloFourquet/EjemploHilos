
package domain;

import java.util.concurrent.*;
import model.ProcesoCallable;
import model.ProcesoRunnable;

public class EjemploCallable{

	public static void main(String[] args) throws InterruptedException, ExecutionException{
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		Future<String> proceso1 = executor.submit(new ProcesoCallable("ProcesoCallable", 150));
		Future<?> proceso2 = executor.submit(new ProcesoRunnable("ProcesoRunnable", 150));
		
		System.out.println("proceso1.get() -> " + proceso1.get());
		System.out.println("proceso2.get() -> " + proceso2.get());
		
		executor.shutdown();
	}

}
