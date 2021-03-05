package utilities;

import java.util.LinkedList;

public class Semaforo {
	private int contador;
	private LinkedList<Object> colaEspera;

	public Semaforo(int contador) {
		this.contador = contador;
		this.colaEspera = new LinkedList<Object>();
	}
//	 Solicitar turno 
	public void p() {
		while (contador <= 0) {
			try {
				Object o = new Object();
				colaEspera.add(o);
				synchronized(o){
					System.out.println("hi"+colaEspera.size());
					o.wait();
					}
				} catch
		 (InterruptedException e) {}
		}
		contador--;
	}
	// Liberar turno 
	public void v(){
		//Vuelve a haber recurso y habia alguien en espera
		if (contador >= 0) {
			Object
			o = colaEspera.poll();
			synchronized (o) {
				contador++;
				o.notifyAll();
			}
		}
	}
}

