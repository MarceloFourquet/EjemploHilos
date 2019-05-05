
package model;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProcesoDeadLock{

	private Account acc1 = new Account();
	private Account acc2 = new Account();
	private Lock lock1 = new ReentrantLock();
	private Lock lock2 = new ReentrantLock();
	Random rnd = new Random();

	@SuppressWarnings({"SleepWhileInLoop", "FinallyDiscardsException"})
	private void acquireLocks(Lock firstLock, Lock secondLock){
		while(true){
			boolean gotFirstLock = false;
			boolean gotSecondLock = false;
			try{
				gotFirstLock = firstLock.tryLock();
				gotSecondLock = secondLock.tryLock();
			}finally{
				if(gotFirstLock && gotSecondLock){
					return;
				}
				if(gotFirstLock){
					firstLock.unlock();
				}
				if(gotSecondLock){
					secondLock.unlock();
				}
			}
			try{
				Thread.sleep(1);
			}catch(InterruptedException ex){
				System.out.println(ex.getMessage());
			}
		}
	}

	public void firstProcess(){
		for(int i = 0; i < 10000; i++){
			acquireLocks(lock1, lock2);
			try{
				Account.transfer(acc1, acc2, rnd.nextInt(100));
			}finally{
				lock1.unlock();
				lock2.unlock();
			}
		}
	}

	public void secondProcess(){
		for(int i = 0; i < 10000; i++){
			acquireLocks(lock2, lock1);
			try{
				Account.transfer(acc2, acc1, rnd.nextInt(100));
			}finally{
				lock2.unlock();
				lock1.unlock();
			}
		}
	}

	public void finallyProcess(){
		System.out.println("Account 1 balance: " + acc1.getBalance());
		System.out.println("Account 2 balance: " + acc2.getBalance());
		System.out.println("Total balance: " + (acc1.getBalance() + acc2.getBalance()));
	}

}
