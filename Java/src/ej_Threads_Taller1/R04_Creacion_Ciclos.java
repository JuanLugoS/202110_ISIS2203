package ej_Threads_Taller1;

public class R04_Creacion_Ciclos implements Runnable{
	
	private final static int MAX = 3;
	
	private String name;

	public R04_Creacion_Ciclos(String n) {
		System.out.println("Implmentacion de interfaz Runnable");
		this.name = n;
	}
	
	@Override
	public void run() {
		System.out.println("El valor inicial es: "+name);
	}

	public static void main (String[] args) {
		Thread[] ta = new Thread[MAX];
		
		for (int i = 0; i < ta.length; i++) {
			ta[i] = new Thread(new R04_Creacion_Ciclos("Thread"+i));
		}
		
		for (int i = 0; i < ta.length; i++) {
			ta[i].start();
		}
		
	}
}
