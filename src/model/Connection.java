
package model;

import java.util.concurrent.Semaphore;

public class Connection{

	private static Connection instance = new Connection();
	private Semaphore sem = new Semaphore(10, true);
	private int connections = 0;

	private Connection(){
	}

	public static Connection getInstance(){
		return instance;
	}

	public void connect(){
		try{
			sem.acquire();
			doConnect();
		}catch(InterruptedException ex){
			System.out.println(ex.getMessage());
		}finally{
			sem.release();
		}
	}

	public void doConnect() throws InterruptedException{
		synchronized(this){
			connections++;
			System.out.println("Current connections: " + connections);
		}
		Thread.sleep(2000);
		synchronized(this){
			connections--;
		}
	}

}
