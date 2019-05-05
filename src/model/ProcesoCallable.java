
package model;

import java.util.concurrent.Callable;

public class ProcesoCallable implements Callable<String>{

	String name;
	int time;

	public ProcesoCallable(String name, int time){
		this.name = name;
		this.time = time;
	}

	@Override
	public String call(){
		for(int i = 1; i <= 5; i++){
			System.out.println(name + " -> i: " + i);
			try{
				Thread.sleep(time);
			}catch(InterruptedException ex){}
		}
		return "Fin " + name;
	}

}
