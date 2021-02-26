package ej_Threads_Taller1;

public class R05_Creacion_CiclosRun implements Runnable{
	
	private String name;

	public R05_Creacion_CiclosRun(String n) {
		System.out.println("Implmentacion de interfaz Runnable");
		this.name = n;
	}
	
	@Override
	public void run() {
		try {
			for (int i = 0; i < 3; i++) {
				System.out.println(name+" valor: "+i);
				Thread.sleep(500);
			}
		} catch (Exception e) {}
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
