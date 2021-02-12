package laboratorios;

import utilities.RandomUT;

public class L2_E2_Persona extends Thread{
	
	private RandomUT rand;
	
	private Integer dir;
	
	private Integer id;
	
	private static Integer contador = 1;
	
	public L2_E2_Persona() {
		dir = rand.randomNumber(0,1);
		id = contador;
		contador++;
	}
	
	public void run() {
		
	}
}
