package uns.tdp.ejemplos.taller;

import uns.tdp.ejemplos.taller.logica.EstacionPintado;

public class Taller {

	public static void main(String[] args) {
		// Creo las estaciones de trabajo que van a pintar los autos.
		EstacionPintado estacion1 = new EstacionPintado(1);
		EstacionPintado estacion2 = new EstacionPintado(2);
		
		// Tomo el tiempo inicial.
		long tiempo_inicial = System.currentTimeMillis();
		
		estacion1.pintar();
		estacion2.pintar();
		
		// Calculo el tiempo total del trabajo.
		long tiempo_final = System.currentTimeMillis();
		long tiempo_trabajo_en_segundos =  (long) Math.ceil((tiempo_final - tiempo_inicial) / 1000);
		
		System.out.println("Tiempo total: " + tiempo_trabajo_en_segundos + "s");
	}
	
}
