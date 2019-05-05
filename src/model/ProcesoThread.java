
package model;

public class ProcesoThread extends Thread{

	private int time;

	public ProcesoThread(String name, int time){
		super(name);
		this.time = time;
	}

	@Override
	public void run(){
		for(int i = 1; i <= 5; i++){
			System.out.println(getName() + " -> i: " + i);
			try{
				ProcesoThread.sleep(time);
			}catch(InterruptedException ex){}
		}
		System.out.println("Fin " + getName());
	}

}
