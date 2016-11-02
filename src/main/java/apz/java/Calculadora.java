package apz.java;

import apz.java.itc.ICalculadora;

/**
 * Nueva API en kkk Java8: Interfaces Funcionales, es una interfaz tiene un único metodo abstracto de uso común.
 * Son anotadas como @FunctionalInterface y se caracterizan porque pueden ser instanciadas por expresion lambdas. 
 */
public class Calculadora {
	
	private int x;
	private int y;
	
	ICalculadora suma = (x,y) -> x + y;
	ICalculadora division = (x,y) -> x / y;
	ICalculadora resta = (x,y) -> x - y;
	ICalculadora multiplicacion = (x,y) -> x*y;
	
	public Calculadora(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int suma(){
		return suma.operacion(x,y);
	}
	public int division(){
		return division.operacion(x,y);
	}
	public int resta(){
		return resta.operacion(x,y);
	}
	public int multiplicacion(){
		return multiplicacion.operacion(x,y);
	}
	
}
