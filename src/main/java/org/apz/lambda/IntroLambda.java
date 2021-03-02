package org.apz.lambda;

/**
 * Intro a la Expresiones Lambda. Una de la nuevas características de java8
 * En matemáticas Lambda es una funcion an�nima, y es que con las expresiones lambda 
 * podemos referenciar métodos anónimos, lo que nos permite escribir código más claro
 * 
 * (parámetros) -> { implementación metodo }
 *
 */

public class IntroLambda {

		/**
		 * Uso de expresion lambda llamando a la interfaz funcional Runnable
		 */
		public static void main(String[] args) {
			
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
			//LLama al metodo run de la interfaz funcional Runnable que no acepta par�metros "()"
			Runnable lambdaRunnable = () -> System.out.println("Hello world, con una expresion lambda");
			new Thread(lambdaRunnable).start();
			
		}
		
	
}

class RunnableImpl implements Runnable {

	@Override
	public void run() {
		System.out.println("Hello World, implementado la interfaz Runnable");
	}

}
