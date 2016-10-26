package apz.lambda;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import apz.java.Calculadora;

public class CalculadoraTest {
	
	
	@Test
	public void testSuma() {
		assertEquals(4, new Calculadora(2,2).suma());
	}
	
	@Test
	public void testDivision() {
		assertEquals(1, new Calculadora(2,2).division());
	}
	
	@Test
	public void testMultiplicacion() {
		assertEquals(4, new Calculadora(2,2).multiplicacion());
	}
	
	@Test
	public void testResta() {
		assertEquals(0, new Calculadora(2,2).resta());
	}

}
