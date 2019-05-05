
package model;

import java.util.ArrayList;
import java.util.Random;

public class Worker{

	private Random random;
	private ArrayList<Integer> list1;
	private ArrayList<Integer> list2;
	private final Object lock1;
	private final Object lock2;

	public Worker(){
		random = new Random();
		list1 = new ArrayList<>();
		list2 = new ArrayList<>();
		lock1 = new Object();
		lock2 = new Object();
	}

	public void stageOne(){
		synchronized(lock1){
			list1.add(random.nextInt(100));
		}
	}

	public void stageTwo(){
		synchronized(lock2){
			list2.add(random.nextInt(100));
		}
	}

	public void process(){
		for(int i = 0; i < 1000; i++){
			stageOne();
			stageTwo();
		}
	}

	public void main(){
		System.out.println("Starting...");
		long startTime = System.currentTimeMillis();
		Thread t1 = new Thread(() -> {
			process();
		});
		Thread t2 = new Thread(() -> {
			process();
		});
		t1.start();
		t2.start();
		try{
			t1.join();
			t2.join();
		}catch(InterruptedException ex){
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Time: " + (endTime - startTime));
		System.out.println("Lista 1: " + list1.size() + " - Lista 2: " + list2.size());
	}

}
