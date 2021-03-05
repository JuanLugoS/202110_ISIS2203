package ej_Threads_Taller1;

public class T02_Creacion_ValorInicial extends Thread{
	
	private int n;
	
	public T02_Creacion_ValorInicial(int n) {
		System.out.println("Extendiendo la clase Thread");
		this.n = n;
	}
	
	public void run() {
		System.out.println("El valor inicial es: "+n);
	}
	
	public static void main(String [] args) {
		T02_Creacion_ValorInicial thread = new T02_Creacion_ValorInicial(5);
		thread.start();
	}
}
