package ej_Threads_Taller1;

public class T1B_EJ2_Contador_MultiT extends Thread{

	private static int contador = 0;
	
	public void run() {
		for (int i = 0; i < 10000; i++) {
			contador++;
		}
	}
	
	public static void main(String [] args) {
		T1B_EJ2_Contador_MultiT[] t = new T1B_EJ2_Contador_MultiT[1000];
		
		for (int i = 0; i < t.length; i++) {
			t[i] = new T1B_EJ2_Contador_MultiT();
			t[i].start();
		}
		
		System.out.println(contador);
	}
}
