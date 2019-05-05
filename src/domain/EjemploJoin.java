
package domain;

public class EjemploJoin{

	private int count = 0;

	public static void main(String[] args){
		EjemploJoin myApp = new EjemploJoin();
		myApp.doSomeWork();
	}

	public void doSomeWork(){
		Thread myThread1 = new Thread(new Runnable(){
			@Override
			public void run(){
				for(int i = 0; i < 10000; i++){
					increment();
				}
			}

		});
		Thread myThread2 = new Thread(new Runnable(){
			@Override
			public void run(){
				for(int i = 0; i < 10000; i++){
					increment();
				}
			}

		});
		myThread1.start();
		myThread2.start();
		
		try{
			myThread1.join();
			myThread2.join();
		}catch(InterruptedException ex){
		}
		
		System.out.println("Count = " + count);
	}
	
	private synchronized void increment(){
		count++;
	}

}
