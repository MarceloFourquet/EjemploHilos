
package domain;

import java.util.concurrent.*;
import model.ProcesoCallable;

public class EjemploCompletionService{

	public static void main(String[] args) throws InterruptedException, ExecutionException{
		ExecutorService executorService = Executors.newFixedThreadPool(8);
		ExecutorCompletionService<String> completionService = new ExecutorCompletionService<>(executorService);
		for(int i = 1; i <= 8; i++){
			completionService.submit(new ProcesoCallable("ProcesoCallable_" + i, 500));
		}
		executorService.shutdown();
		while(!executorService.isTerminated()){
			Future<String> future = completionService.take();
			System.out.println(future.get());
		}
	}

}
