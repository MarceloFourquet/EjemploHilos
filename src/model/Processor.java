
package model;

import java.util.LinkedList;
import java.util.Random;

public class Processor{

	private LinkedList<Integer> list;
	private final int LIMIT;
	private final Object lock;

	public Processor(){
		this.list = new LinkedList<>();
		this.LIMIT = 10;
		this.lock = new Object();
	}
	
	public void produce() throws InterruptedException{
		int value = 0;
		while(true){
			synchronized(lock){
				while(list.size() == LIMIT){
					lock.wait();
				}
				list.add(value++);
				lock.notify();
			}
		}
	}

	@SuppressWarnings("SleepWhileInLoop")
	public void consume() throws InterruptedException{
		
		Random rnd = new Random();
		while(true){
			synchronized(lock){
				while(list.isEmpty()){
					lock.wait();
				}
				System.out.print("List size is: " + list.size());
				int value = list.removeFirst();
				System.out.println("; value is: " + value);
				lock.notify();
			}
			Thread.sleep(rnd.nextInt(1000));
		}
	}

}
