# Java SE 1.8

#### Expresiones Lambda

En matemáticas Lambda es una funcion anónima, y es que con las expresiones lambda podemos referenciar métodos anónimos, lo que nos permite escribir código más claro

**Interfaces Funcionales**

Son anotadas como @FunctionalInterface y se caracterizan porque pueden ser instanciadas por expresion lambdas, por lo que estas interfaces tienen un único metodo abstracto.

    (parámetros) -> { implementación metodo }

**Stream**

Se introduce un nuevo interfaz java.util.**Stream** permiten realizar operaciones funcionales sobre los elementos de las colecciones.

**Optional**


**Documentacion**
	
lambda: https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html

# Colecciones en java

Una **colección** agrupa a un conjunto dinámico de elementos, a diferencia de un **array** que es un conjunto estático se fija el tamaño y no puede cambiar.

En Java, se emplea la interfaz genérica java.util.**Collection** para este propósito. Partiendo de Collection extienden otras interfaces genéricas que define los tipos de colecciones según la funcionalidad que se necesite:

## Set

Colección que no puede contener elementos duplicados. Para comprobar si los elementos son elementos duplicados o no lo son, es necesario que dichos elementos tengan implementada los métodos *equals* y *hashCode*


* HashSet. Almacena los elementos en una tabla hash. Es la implementación con mejor rendimiento. No permite la ordenacion de elementos
* TreeSet Permite la ordenación

### List

Colección que s sí admite elementos duplicados, permite el acceso a un determinado elemento con un índice

* ArrayList Se basa en un array redimensionable. Es la que mejor rendimiento tiene sobre la mayoría de situaciones.
* LinkedList Esta implementación se basa en una lista doblemente enlazada de los elementos, teniendo cada uno de los elementos un puntero al anterior y al siguiente elemento

## Map

La interfaz Map asocia claves a valores. Esta interfaz no puede contener claves duplicadas 

* HashMap: este implementación almacena las claves en una tabla hash. Es la implementación con mejor rendimiento.
* TreeMap: esta implementación almacena las claves ordenándolas en función de sus valores. Es bastante más lento que HashMap. Las claves almacenadas deben implementar la interfaz Comparable. Esta implementación garantiza, siempre, un rendimiento de log(N) en las operaciones básicas, debido a la estructura de árbol empleada para almacenar los elementos.
* LinkedHashMap: esta implementación almacena las claves en función del orden de inserción. Es, simplemente, un poco más costosa que HashMap.


Ninguna de las implementaciones de las colecciones son sincronizadas; es decir, no son thread-safe Esto se puede solucionar empleando una serie de métodos que actúan de wrapper para dotar a estas colecciones de esta falta de sincronización:

	Set set = Collections.synchronizedSet(new HashSet());

![decisiones](https://www.adictosaltrabajo.com/wp-content/uploads/2015/09/java-collections-img1-1024x734.png)


**Documentacion**

https://docs.oracle.com/javase/tutorial/collections/TOC.html


# Genericos en java

Los genericos fueron introducidos en el JSE 5; hace referencia a tipos parametrizados. Esto es, se permite crear clases, interfaces y métodos en los que el tipo de datos sobre los que operan se especifica como parámetro. Una clase, interfaz o método que funciona con un tipo de parámetro se denomina genérico, como una clase genérica o método genérico.

Box es una clase genérica

	public class Box<T> {

	  private T t;
	  
	  public Box(T t) {
	        this.t = t;
	  }
	  
	  public T get() { return t; }
	  public void set(T t) { this.t = t; }

	}

T es un parámetro de tipo que será reemplazado por un tipo real cuando se genere un objeto de tipo Box

	Box<String> box = new Box<String>("hola");

Según las convenciones los nombres de los parámetros son:

* E: elemento de una colección.
* K: clave.
* N: número.
* T: tipo.
* V: valor.

En el JSE 7 se puede usar el **operador diamond** y el compilador inferirá el tipo según su definición para mayor claridad en el código:

	Box<String> box = new Box<>("hola");

	
Se puede definir un tipo ? se denomina **wildcard** siendo este un tipo desconocido. 


**Documentacion**

https://docs.oracle.com/javase/tutorial/java/generics/index.html	
	
	