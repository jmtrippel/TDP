package uns.tdp.ejemplos.taller.threads;

import uns.tdp.ejemplos.taller.logica.EstacionPintado;

public class EstacionPintadoThread extends Thread {
	
	// La estacion de trabajo subyacente.
	private EstacionPintado mLogica;
	
	public EstacionPintadoThread(EstacionPintado logica) {
		this.mLogica = logica;
	}
	
	@Override
	public void run() {
		while(!Thread.interrupted()) {
			this.mLogica.pintar();
		}
	}
}
