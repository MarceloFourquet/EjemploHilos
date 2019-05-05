
package domain;

import model.ProcesoDeadLock;

public class EjemploDeadLock{

	public static void main(String[] args){
		
		final ProcesoDeadLock process = new ProcesoDeadLock();
		
		Thread t1 = new Thread(() -> {
			process.firstProcess();
		});
		
		Thread t2 = new Thread(() -> {
			process.secondProcess();
		});
		
		t1.start();
		t2.start();
		try{
			t1.join();
			t2.join();
		}catch(InterruptedException ex){
			System.out.println(ex.getMessage());
		}
		process.finallyProcess();
	}
	
}
