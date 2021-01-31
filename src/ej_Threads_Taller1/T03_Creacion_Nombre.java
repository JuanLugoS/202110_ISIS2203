package ej_Threads_Taller1;

public class T03_Creacion_Nombre extends Thread{
	
	private String n;
	
	public T03_Creacion_Nombre(String n) {
		System.out.println("Extendiendo la clase Thread");
		this.n = n;
	}
	
	public void run() {
		System.out.println("El valor inicial es: "+n);
	}
	
	public static void main(String [] args) {
		T03_Creacion_Nombre thread0 = new T03_Creacion_Nombre("Thread"+0);
		T03_Creacion_Nombre thread1 = new T03_Creacion_Nombre("Thread"+1);
		T03_Creacion_Nombre thread2 = new T03_Creacion_Nombre("Thread"+2);
		
		thread0.start();
		thread1.start();
		thread2.start();
	}
}
