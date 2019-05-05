
package model;

import java.util.Scanner;
import java.util.concurrent.locks.*;

public class ReentrantLockProcess{

	private int count = 0;
	private Lock lock = new ReentrantLock();
	private Condition cond = lock.newCondition();

	private void increment(){
		for(int i = 0; i < 10000; i++){
			count++;
		}
	}

	public void firstProcess(){
		lock.lock();
		System.out.println("firstProcess waiting...");
		try{
			cond.await();
			System.out.println("firstProcess woken up!");
			System.out.println("firstProcess working");
			increment();
		}catch(InterruptedException ex){
			ex.printStackTrace();
		}finally{
			lock.unlock();
		}
	}

	public void secondProcess(){
		try{
			Thread.sleep(1000);
			lock.lock();
			System.out.print("Press return key...");
			new Scanner(System.in).nextLine();
			System.out.println("secondProcess get the return key!");
			cond.signal();
			System.out.println("secondProcess working");
			increment();
		}catch(InterruptedException ex){
			ex.printStackTrace();
		}finally{
			lock.unlock();
		}
	}

	public void finishProcess(){
		System.out.println("Count is: " + count);
	}

}
