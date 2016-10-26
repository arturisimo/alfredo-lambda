package apz.java;

import java.util.List;
import java.util.function.Predicate;

import apz.java.bean.Student;


/**
 * Por medio de expresiones lambda podemos referenciar métodos anónimos o métodos sin nombre, 
 * lo que nos permite escribir código más claro y conciso que  cuando usamos clases anónimas. 
 * 
 * Una expresión lambda se compone de:
 * Listado de parámetros separados por comas y encerrados en paréntesis, por ejemplo: (a,b).
 * El símbolo de flecha hacia la derecha: ->
 * Un cuerpo que puede ser un bloque de código encerrado entre llaves o una sola expresión.
 * 
 *
 */
public class Students {
	
	private List<Student> estudiantes;
	
	
	private Predicate<Student> tester = student -> student.getGender() == Student.Sex.MALE 
																&& student.getAge() >= 18 
																&& student.getAge() <= 25;
	
	public Students(List<Student> estudiantes) {
		this.estudiantes = estudiantes;
	}
																
	public int printPersonsOlderThan(int age) {
		return estudiantes.stream()
						  .filter(p->p.getAge() > age).toArray().length;
	}
	
	public void printPersonsWithinAgeRange(List<Student> estudiantes, int low, int high) {
		estudiantes.stream()
		  .filter(p -> low <= p.getAge() && p.getAge() < high)
		  .forEach(System.out::println);
	}
	
	public int listStudentValidation() {
		return estudiantes.stream()
				  		  .filter(p->tester.test(p)).toArray().length;
		
	}

}
