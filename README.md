## alfredo-lambda
Nuevas funcionalidades de Java SE 1.8

####Expresiones Lambda
En matemáticas Lambda es una funcion anónima, y es que con las expresiones lambda 
podemos referenciar métodos anónimos, lo que nos permite escribir código más claro

####Interfaces Funcionales
Es una interfaz tiene un único metodo abstracto de uso común.
Son anotadas como @FunctionalInterface y se caracterizan porque pueden ser instanciadas por expresion lambdas. 

    (parámetros) -> { implementación metodo }

####Nashorn 
Es un motor de JavaScript que remplaza a **Rhino Engine (JDK6)**
 * Es un Motor JavaScript ECMA.
 * Consola jjs para ir ejecutando linea a linea o lanzar ficheros JavaScript
 * Java Scripting API (JSR 223): Integración dentro de aplicaciones Java
 * Integración de Java dentro de JavaScript

####Ejecutar las pruebas

    $ git clone https://github.com/arturisimo/alfredo-lamba
    $ cd alfredo-lamba
    $ mvn clean install
