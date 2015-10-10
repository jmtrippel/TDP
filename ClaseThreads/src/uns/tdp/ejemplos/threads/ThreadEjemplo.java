package uns.tdp.ejemplos.threads;

public class ThreadEjemplo extends Thread {

	public ThreadEjemplo(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println(i + " " + getName());
		}
		System.out.println("Termina thread " + getName());
	}
	
	public static void main(String[] args) {
		new ThreadEjemplo("Hilo 1").start();
		new ThreadEjemplo("Hilo 2").start();
		
		System.out.println("Termina thread main");
	}
}
