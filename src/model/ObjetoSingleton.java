
package model;

import java.util.concurrent.locks.ReentrantLock;

public class ObjetoSingleton{

	private String owner;
	private static ObjetoSingleton miObjeto;
	private static ReentrantLock lock = new ReentrantLock();

	private ObjetoSingleton(String owner){
		this.owner = owner;
	}

	public static ObjetoSingleton getMiRegularObject(String owner){
		if(miObjeto == null){
			miObjeto = new ObjetoSingleton(owner);
		}
		return miObjeto;
	}

	public static synchronized ObjetoSingleton getMiSyncronizedObject(String owner){
		if(miObjeto == null){
			miObjeto = new ObjetoSingleton(owner);
		}
		return miObjeto;
	}

	public static ObjetoSingleton getMiLockObject(String owner){
		lock.lock();
		try{
			if(miObjeto == null){
				miObjeto = new ObjetoSingleton(owner);
			}
		}finally{
			lock.unlock();
		}
		return miObjeto;
	}

	public String getOwner(){
		return owner;
	}

}
