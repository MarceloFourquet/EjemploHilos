
package domain;

import model.ProcesoThread;
import model.ProcesoRunnable;

public class EjemploThreadRunnable{

	public static void main(String[] args) throws InterruptedException{
		
		for(int i = 1; i <= 5; i++){
			new ProcesoThread("ProcesoThread_" + i, 100).start();
		}
		System.out.println("Fin loop Thread");
		
		for(int i = 1; i <= 5; i++){
			new Thread(new ProcesoRunnable("ProcesoRunnable_" + i, 100)).start();
		}
		System.out.println("Fin loop Runnable");
		
		System.out.println("Fin main");
	}

}
