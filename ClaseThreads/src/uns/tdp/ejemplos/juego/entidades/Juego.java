package uns.tdp.ejemplos.juego.entidades;

import java.util.Random;

import uns.tdp.ejemplos.juego.gui.GUI;
import uns.tdp.ejemplos.juego.threads.MaloThread;

public class Juego {
	
	private MaloThread mMalos[];
	
	private Jugador mJugador;
	
	public Juego(GUI gui){
		// Creo el jugador y lo agrego el grafico a la gui.
		this.mJugador = new Jugador(15, 10, 10);
		gui.add(this.mJugador.getGrafico());
		
		// Creo los malos y agrego a la gui su grafico.
		this.mMalos = new MaloThread[3];
		for(int i = 0; i < this.mMalos.length; i++){
			Random r = new Random();
			
			Malo malo = new Malo(10, r.nextInt(gui.getWidth() - 32), r.nextInt(gui.getHeight() - 32));
			this.mMalos[i] = new MaloThread(malo);
			gui.add(malo.getGrafico());
			
			this.mMalos[i].start();
		}
	}
	
	public void mover(int dir){
		this.mJugador.mover(dir);
	}
	
	
	public void destruir(int malo) {
		if(this.mMalos[malo] != null) {
			this.mMalos[malo].destruir();
			this.mMalos[malo] = null;
		}
	}

}