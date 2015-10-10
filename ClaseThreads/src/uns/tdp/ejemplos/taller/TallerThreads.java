package uns.tdp.ejemplos.taller;

import uns.tdp.ejemplos.taller.logica.EstacionPintado;
import uns.tdp.ejemplos.taller.threads.EstacionPintadoThread;

public class TallerThreads {

	public TallerThreads() {
		// Creo los hilos y las estaciones de trabajo que van a pintar los autos.
		EstacionPintadoThread estacion1 = new EstacionPintadoThread(new EstacionPintado(1));
		EstacionPintadoThread estacion2 = new EstacionPintadoThread(new EstacionPintado(2));
		
		// Tomo el tiempo inicial.
		long tiempo_inicial = System.currentTimeMillis();
		
		// Inicio los hilos.
		estacion1.start();
		estacion2.start();
		
		// Espero por los hilos de ejecucion para que terminen sus tareas.
		try {
			estacion1.join();
			estacion2.join();
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
