package ej_Threads_Taller1;

public class R01_Creacion implements Runnable{

	@Override
	public void run() {
		System.out.println("Implmentacion de interfaz Runnable");
	}
	
	public static void main(String[] args) {
		Thread t = new Thread(new R01_Creacion());
		t.start();
	}
	
}
