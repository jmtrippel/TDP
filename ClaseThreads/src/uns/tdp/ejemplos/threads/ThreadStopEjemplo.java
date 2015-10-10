package uns.tdp.ejemplos.threads;

public class ThreadStopEjemplo implements Runnable {

	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println(i + " " + Thread.currentThread().getName());
		}
		System.out.println("Termina thread " + Thread.currentThread().getName());
	}
	
	
	public static void main (String [] args) {
		 new Thread (new ThreadStopEjemplo(), "Hilo 1").start();
		 new Thread (new ThreadStopEjemplo(), "Hilo 2").start();
		 
		 System.out.println("Termina thread main");
	 } 
}
