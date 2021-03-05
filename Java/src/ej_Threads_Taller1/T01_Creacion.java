package ej_Threads_Taller1;

public class T01_Creacion extends Thread{
	
	public void run() {
		System.out.println("Extendiendo la clase Thread");
	}
	
	public static void main(String [] args) {
		T01_Creacion thread =new T01_Creacion();
		thread.start();
	}
	
}

