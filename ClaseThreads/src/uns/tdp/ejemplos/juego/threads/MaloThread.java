package uns.tdp.ejemplos.juego.threads;

import uns.tdp.ejemplos.juego.entidades.Malo;

public class MaloThread extends Thread {
	
	// Logica que implementa al malo.
	private Malo mLogica;
	
	// Flag que indica cuando debe detenerse la ejecución del hilo.
	private boolean mDetener;
	
	public MaloThread(Malo logica) {
		this.mLogica  = logica;
		this.mDetener = false;
	}
	
	@Override
	public void run() {
		// Ejecuto indefinidamente hasta que el flag sea verdadero.
		while(!this.mDetener){
			// Realizo el movimiento
			this.mLogica.mover();
			
			// Duermo el hilo 1 segundo.
			// De esta manera cada turno se ejecuta cada 1 segundo.
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public void destruir() {
		// Interrumpo el hilo para que no continue con su ejecución.
		Thread.currentThread().interrupt();
		
		// Seteamos el flag para detener su ejecución.
		this.mDetener = true;
		
		// Notificamos a la logica que este hilo se destruyo.
		this.mLogica.destruir();
	}
}