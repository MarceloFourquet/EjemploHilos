
package model;

public class ProcesoUsuarioObjetoSingleton implements Runnable{

	int time;
	String name;

	public ProcesoUsuarioObjetoSingleton(String name, int time){
		this.name = name;
		this.time = time;
	}

	@Override
	public void run(){
		try{
			Thread.sleep(time);
		}catch(InterruptedException ex){
		}
		ObjetoSingleton obj = ObjetoSingleton.getMiRegularObject(name);
		// ObjetoSingleton obj = ObjetoSingleton.getMiSyncronizedObject(name);
		// ObjetoSingleton obj = ObjetoSingleton.getMiLockObject(name);
		System.out.println("Dueño del objeto singleton de " + name + " -> " + obj.getOwner());
	}

}
