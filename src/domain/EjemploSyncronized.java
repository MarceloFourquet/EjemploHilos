
package domain;

import model.ProcesoUsuarioObjetoSingleton;

public class EjemploSyncronized{

	public static void main(String[] args){
		for(int i = 1; i <= 15; i++){
			new Thread(new ProcesoUsuarioObjetoSingleton("ProcesoUsuario_" + i, 500)).start();
		}
	}

}
