package apz.java;

import apz.java.itc.ICalculadora;

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
