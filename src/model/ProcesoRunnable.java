
package model;

public class ProcesoRunnable implements Runnable{

	private String name;
	private int time;

	public ProcesoRunnable(String name, int time){
		this.name = name;
		this.time = time;
	}

	@Override
	public void run(){
		for(int i = 1; i <= 5; i++){
			System.out.println(name + " -> i: " + i);
			try{
				Thread.sleep(time);
			}catch(InterruptedException ex){}
		}
		System.out.println("Fin " + name);
	}

}
