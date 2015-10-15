package uns.tdp.ejemplos.juego.threads;

import uns.tdp.ejemplos.juego.entidades.Malo;

public class MaloThread extends Thread {
	
	// Logica que implementa al malo.
	private Malo mLogica;
	
	// Flag que indica cuando debe detenerse la ejecuci�n del hilo.
	// Es volatile porque es accedida desde concurrentemente desde diferentes threads.
	private volatile boolean mDetener;
	
	public MaloThread(Malo logica) {
		this.mLogica  = logica;
		this.mDetener = false;
	}
	
	@Override
	public void run() {
		// Ejecuto indefinidamente hasta que el flag sea verdadero.
		while(!this.mDetener){
			// Duermo el hilo 1 segundo.
			// De esta manera cada turno se ejecuta cada 1 segundo.
			try {
				Thread.sleep(1000);
				
				// Realizo el movimiento
				this.mLogica.mover();
			} catch (InterruptedException e) { }
		}
	}
	
	public void detener() {
		// Interrumpo el hilo para que no continue con su ejecuci�n.
		this.interrupt(); 
		
		// Seteamos el flag para detener su ejecuci�n.
		this.mDetener = true;
	}
	
	public void destruir() {
		// Detengo la ejecucion del hilo.
		this.detener();
		
		// Notificamos a la logica que este hilo se destruyo.
		this.mLogica.destruir();
	}
}