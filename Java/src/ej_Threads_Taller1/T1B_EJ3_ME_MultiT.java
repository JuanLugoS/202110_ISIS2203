package ej_Threads_Taller1;

import java.util.concurrent.*;

import utilities.Maximo;

public class T1B_EJ3_ME_MultiT extends Thread{
	
	private final static int INT_MAX = 105345;
		
	private final static int DIM = 3;
	
	private static int[][] matriz = new int[DIM][DIM];
	
	private static Maximo mayor = new Maximo();
	
	private int mayorFila = -1;
	
	private int idThread;
	
	private int fila;
	
	public T1B_EJ3_ME_MultiT(int pIdThread, int pFila) {
		this.idThread = pIdThread;
		this.fila = pFila;
	}
	
	public static void crearMatriz() {
		for (int i = 0; i < DIM; i++) {
			for (int j = 0; j < DIM; j++) {
				matriz[i][j] = ThreadLocalRandom.current().nextInt(0, INT_MAX);
			}
		}
		
		System.out.println("Matriz");
		System.out.println("====================");
		imprimirMatriz();
	}
	
	private static void imprimirMatriz() {
		for (int i = 0; i < DIM; i++) {
			for (int j = 0; j < DIM; j++) {
				System.out.print(matriz[i][j]+"\t");
			}
			System.out.println();
		}
	}
	
	public void run() {
		for (int i = 0; i < DIM; i++) {
			if (this.mayorFila<matriz[this.fila][i]) {
				
				this.mayorFila = matriz[this.fila][i];
			}
		}
		if (this.mayorFila > mayor.darMaximo()) {
			try {
				Thread.sleep(250);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			mayor.anotar(this.mayorFila);
			String warn = String.format("=========== Nuevo maximo encontrado ========== \n"
									  + "ID Thread: %d - Maximo local actual: %d - Maximo global: %d \n"
									  + "\n", this.idThread, mayor.darMaximo(), this.mayorFila);
			System.out.println(warn);
		}
		
		String msg = String.format("ID Thread: %d - Maximo local: %d - Maximo global: %d", this.idThread, this.mayorFila, mayor.darMaximo() );
		System.out.println(msg);
	}
	
	public static void main (String[] args) {
		System.out.println("Busqueda concurrente por una matriz");
		
		T1B_EJ3_ME_MultiT.crearMatriz();
		System.out.println();
		System.out.println("Iniciando la busqueda por la matriz \n");
		
		T1B_EJ3_ME_MultiT[] bThreads = new T1B_EJ3_ME_MultiT[DIM];
		for (int i = 0; i < DIM; i++) {
			bThreads[i] = new T1B_EJ3_ME_MultiT(i, i);
			bThreads[i].start();
		}
	}
}
