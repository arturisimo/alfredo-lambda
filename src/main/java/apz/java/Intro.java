package apz.java;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Intro a la Expresiones Lambda. Una de la nuevas características de java8
 * En matemáticas Lambda es una funcion anónima, y es que con las expresiones lambda 
 * podemos referenciar métodos anónimos, lo que nos permite escribir código más claro
 * 
 * (parámetros) -> { implementación metodo }
 *
 */

public class Intro {

		public static void main(String[] args) {

			introLambda();
			
			introSortCollection();
			
		}

		/**
		 * Uso de expresion lambda llamando a la interfaz funcional Runnable
		 */
		private static void introLambda() {
			
			//implementado la interfaz Runnable
			Runnable r = new RunnableImpl();
			new Thread(r).start();
			
			//usando una clase interna
			Runnable innerRunnable = new Runnable() {
				
				@Override
				public void run() {
					System.out.println("Hello world con una clase embebida");
				}
			};
			new Thread(innerRunnable).start();
			
			//clase anonima
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					System.out.println("Hello world, con una clase anonima");
				}
				
			}).start();
			
			//Expresion lambda. Hace uso del operador lambda "->"
			//LLama al metodo run de la interfaz funcional Runnable que no acepta parámetros "()"
			Runnable lambdaRunnable = () -> System.out.println("Hello world, con una expresion lambda");
			new Thread(lambdaRunnable).start();
			
		}
		
		/**
		 * Ejemplo de ordenacion de un list con una expresion lambda
		 */
		private static void introSortCollection() {
			
			List<String> listaNombres = Arrays.asList("Mary", "Kevin", "Jose", "John", "Ana");
			
			Comparator<String> comparator = (string1, string2) -> string1.compareToIgnoreCase(string2);
			Collections.sort(listaNombres, comparator);
			
			listaNombres.forEach(nombre -> System.out.println(nombre));
			
		}
	
}

class RunnableImpl implements Runnable {

	@Override
	public void run() {
		System.out.println("Hello World, implementado la interfaz Runnable");
	}

}
