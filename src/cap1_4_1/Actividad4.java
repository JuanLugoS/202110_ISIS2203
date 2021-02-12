package cap1_4_1;

import utilities.Maximo;

public class Actividad4 extends Thread {
	private static Maximo oMax = new Maximo();
	private int num = 0;

	public Actividad4(int n) {
		num = n;
	}

	public void run() {
		oMax.anotar(num);
		System.out.println("acaba t"+num);
		System.out.println("El nuevo máximo es: " + oMax.darMaximo());	
	}

	public static void main(String[] args) {
		
			for (int i = 0; i < 10; i++)
				new Actividad4(i).start();
			System.out.println("-----El máximo es: " + oMax.darMaximo());	
			
	}
}