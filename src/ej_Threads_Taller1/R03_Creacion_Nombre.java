package ej_Threads_Taller1;

public class R03_Creacion_Nombre implements Runnable{
	
	private String name;

	public R03_Creacion_Nombre(String n) {
		System.out.println("Implmentacion de interfaz Runnable");
		this.name = n;
	}
	
	@Override
	public void run() {
		System.out.println("El valor inicial es: "+name);
	}

	public static void main (String[] args) {
		Thread t0 = new Thread(new R03_Creacion_Nombre("Thread"+0));
		Thread t1 = new Thread(new R03_Creacion_Nombre("Thread"+1));
		Thread t2 = new Thread(new R03_Creacion_Nombre("Thread"+2));
		
		t0.start();
		t1.start();
		t2.start();
	}
}
