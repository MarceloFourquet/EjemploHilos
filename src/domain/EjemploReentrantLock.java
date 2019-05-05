
package domain;

import model.ReentrantLockProcess;

public class EjemploReentrantLock{

	public static void main(String[] args){
		
		final ReentrantLockProcess process = new ReentrantLockProcess();
		
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
		}catch(InterruptedException ex){}
		
		process.finishProcess();
	}

}
