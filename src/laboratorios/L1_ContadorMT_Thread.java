/**
 * Universidad de Los Andes
 * ISIS 2203 - Infraestructura Computacional
 * Ejercicio de laboratorio
 * 29 de enero de 2021
 * 
 * @author Juan Lugo Sánchez
 * jd.lugo@uniandes.edu.co
 * 201913094
 */

package laboratorios;

import java.util.Scanner;

public class L1_ContadorMT_Thread extends Thread {

	// Valor desde el que se comienza a contar
	private Integer num = 0;

	// Valor limite hasta el que se cuenta
	private Integer limit = 0;

	// Metodo constructor
	public L1_ContadorMT_Thread(Integer pNum, Integer pLimit) {
			System.out.println("Iniciando Thread");
			this.num = pNum;
			this.limit = pLimit;
		}
	
	/**
	 * El funcionamiento del thread consiste en imprimir un numero
	 * cada 2, es decir, si comienza en 1 imprimirá los impares y si
	 * comienza en 2 imprimirá los pares.
	 */
	public void run() {
		try {
			for (int i = num; i <= limit; i=i+2) {
				System.out.println(i);
				
				//Tiempo entre cada impresion: 50 ms
				Thread.sleep(50);
			}
		} catch (Exception e) {}
	}
	
public static void main (String[] args) {
		
		System.out.println("Digite el limite de numeros a imprimir");
		
		//Mediante Scanner de java.util se recolecta el numero desde consola
		@SuppressWarnings("resource")
		Scanner lector = new Scanner(System.in);
		
		//El numero que se recibe en consola se guarda aqui
		Integer limit = lector.nextInt();
		
		//Creacion de los threads
		L1_ContadorMT_Thread t0 = new L1_ContadorMT_Thread(1,limit);
		L1_ContadorMT_Thread t1 = new L1_ContadorMT_Thread(2,limit);
		
		//Inicio de los threads
		t0.start();
		t1.start();
	}
}
