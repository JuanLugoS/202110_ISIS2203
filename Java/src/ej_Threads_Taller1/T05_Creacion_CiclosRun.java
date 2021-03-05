package ej_Threads_Taller1;

public class T05_Creacion_CiclosRun extends Thread{

	private String n;
	
	public T05_Creacion_CiclosRun(String n) {
		System.out.println("Extendiendo la clase Thread");
		this.n = n;
	}
	
	public void run() {
		try {
			for (int i = 0; i < 5; i++) {
				System.out.println(n+" valor: "+i);
				Thread.sleep(50);
			}
		} catch (Exception e) {}
	}
	
	public static void main(String [] args) {
		T05_Creacion_CiclosRun thread0 = new T05_Creacion_CiclosRun("Thread"+0);
		T05_Creacion_CiclosRun thread1 = new T05_Creacion_CiclosRun("Thread"+1);
		T05_Creacion_CiclosRun thread2 = new T05_Creacion_CiclosRun("Thread"+2);
		
		thread0.start();
		thread1.start();
		thread2.start();
	}
}
