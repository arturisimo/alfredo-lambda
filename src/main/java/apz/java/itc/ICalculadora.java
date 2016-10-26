package apz.java.itc;

/**
 * Nueva API en Java8 interfaces funcionales, interfaces que declaran funciones de uso común. 
 * 
 * Son anotadas como @FunctionalInterface y podemos utilizarla en una interfaz que 
 * queramos declarar como funcional. Se caracterizan porque pueden ser instanciadas por lambdas. 
 *
 */
@FunctionalInterface
public interface ICalculadora {
	
	public int operacion(int x, int y);

}
