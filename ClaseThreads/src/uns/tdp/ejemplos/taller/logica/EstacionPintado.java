package uns.tdp.ejemplos.taller.logica;

public class EstacionPintado {

	// Identifica univocamente la estacion.
	private int mIdentificador;
	
	/**
	 * Estacion de pintado para pintar autos.
	 */
	public EstacionPintado(int identificador) {
		this.mIdentificador = identificador;
	}
	
	/**
	 * Pinta un auto.
	 * El tiempo de demora es proporcional a la superficie del auto a pintar.
	 * @param auto
	 */
	public void pintar() {
		// Tomo el tiempo inicial.
		long tiempo_inicial = System.currentTimeMillis();
		
		System.out.println("Comienza el trabajo de pintura en la estacion " + this.mIdentificador);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
		
		// Calculo el tiempo total del trabajo.
		long tiempo_final = System.currentTimeMillis();
		long tiempo_trabajo_en_segundos =  (long) Math.ceil((tiempo_final - tiempo_inicial) / 1000);
		
		System.out.println("Termina el trabajo de pintura en la estacion " + this.mIdentificador + " en " + tiempo_trabajo_en_segundos + "s");
	}
	
}
