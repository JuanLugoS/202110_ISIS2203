package ej_Threads_Taller1;

public class T04_Creacion_Ciclos extends Thread{
	
	private final static int MAX = 3;
	
	private String n;
	
	public T04_Creacion_Ciclos(String n) {
		System.out.println("Extendiendo la clase Thread");
		this.n = n;
	}
	
	public void run() {
		System.out.println("El valor inicial es: "+n);
	}
	
	public static void main(String [] args) {
		
		T04_Creacion_Ciclos[] ta = new T04_Creacion_Ciclos[MAX];
		
		for (int i = 0; i < ta.length; i++) {
			ta[i] = new T04_Creacion_Ciclos("Thread"+i);
		}
		
		for (int i = 0; i < ta.length; i++) {
			ta[i].start();
		}
		
	}
}
