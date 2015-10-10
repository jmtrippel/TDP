package uns.tdp.ejemplos.taller;

import uns.tdp.ejemplos.taller.logica.EstacionPintado;
import uns.tdp.ejemplos.taller.threads.EstacionPintadoRunnable;

public class TallerRunnable {

	public TallerRunnable() {
		// Creo los hilos y las estaciones de trabajo que van a pintar los autos.
		EstacionPintadoRunnable estacion1 = new EstacionPintadoRunnable(new EstacionPintado(1));
		EstacionPintadoRunnable estacion2 = new EstacionPintadoRunnable(new EstacionPintado(2));
		
		// Tomo el tiempo inicial.
		long tiempo_inicial = System.currentTimeMillis();
		
		// Inicio los hilos.
		Thread hilo_estacion1 = new Thread(estacion1);
		Thread hilo_estacion2 = new Thread(estacion2);
		
		// Espero por los hilos de ejecucion para que terminen sus tareas.
		try {
			hilo_estacion1.join();
			hilo_estacion2.join();
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
		
		// Calculo el tiempo total del trabajo.
		long tiempo_final = System.currentTimeMillis();
		long tiempo_trabajo_en_segundos =  (long) Math.ceil((tiempo_final - tiempo_inicial) / 1000);
		
		System.out.println("Tiempo total: " + tiempo_trabajo_en_segundos + "s");
	}
	
	public static void main(String[] args) {
		new TallerThreads();	
	}
}
