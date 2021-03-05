package ej_Threads_Taller1;

public class R02_Creacion_ValorInicial implements Runnable{
	
	private int n;

	public R02_Creacion_ValorInicial(int n) {
		System.out.println("Implmentacion de interfaz Runnable");
		this.n = n;
	}
	
	@Override
	public void run() {
		System.out.println("El valor inicial es: "+n);
	}

	public static void main (String[] args) {
		Thread t = new Thread(new R02_Creacion_ValorInicial(5));
		t.start();
	}
}
