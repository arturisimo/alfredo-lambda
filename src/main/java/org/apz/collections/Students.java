package org.apz.collections;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

import org.apz.collections.pojo.Student;


/**
 * Strem API y Uso de la interfaz Predicate
 *
 */
public class Students {
	
	private List<Student> estudiantes;
	
	public Students(List<Student> estudiantes) {
		this.estudiantes = estudiantes;
	}
		
	
	/**
	 * Filtrado de lista de estudiantes
	 * @param estudiantes
	 * @param ageLow
	 * @param ageHigh
	 */
	public long printPersonsOlderThan(int age) {
		return estudiantes.stream()
						  .filter(p->p.getAge() > age).count();
	}
	
	/**
	 * Filtrado de lista de estudiantes
	 * @param estudiantes
	 * @param ageLow
	 * @param ageHigh
	 */
	public void printPersonsWithinAgeRange(List<Student> estudiantes, int ageLow, int ageHigh) {
		estudiantes.stream()
		  		   .filter(p -> ageLow <= p.getAge() && p.getAge() < ageHigh)
		  		   .forEach(System.out::println);
	}
	
	/**
	 * Filtrado usando el metodo test de Predicate
	 * @return numero de estudiantes que cumplen tester
	 */
	public int listStudentValidation() {
		
		//estudiantes varones de 18 a 25
		Predicate<Student> predicateTester = student -> student.getGender() == Student.Sex.MALE 
														&& student.getAge() >= 18 
														&& student.getAge() <= 25;
		
		return estudiantes.stream()
						  .filter(p->predicateTester.test(p)).toArray().length;
	}
	
	
	public List<Student> listEstudiantesPorEdad() {
		Collections.sort(estudiantes, Student::compareAges);
		return estudiantes;
	}
	

}
