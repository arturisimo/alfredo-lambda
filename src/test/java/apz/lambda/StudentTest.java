package apz.lambda;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.apz.collections.Students;
import org.apz.collections.pojo.Student;
import org.apz.collections.pojo.Student.Sex;
import org.junit.Test;

/**
 * Intro Stream
 *
 */
public class StudentTest {
	
	private static List<Student> STUDENTS = Arrays.asList(new Student(1, 18, Sex.MALE, "john", 9.90),
													  new Student(2, 15, Sex.MALE, "marcos", 8.90),
													  new Student(3, 16, Sex.FEMALE, "ana", 7.90));
	
	/**
	 * hombre de 18 a 25
	 */
	@Test
	public void testValidacion() {
		
		Students instance = new Students(STUDENTS);
		int numEstudiantes = instance.listStudentValidation();
		assertEquals(numEstudiantes, 1);
	}
	
	
	@Test
	public void testListarMayorDe() {
		
		Students instance = new Students(STUDENTS);	
		
		long numEstudiantes = instance.printPersonsOlderThan(17);
		assertEquals(numEstudiantes, 1L);
			
	}
	
	
	@Test
	public void testListarEstudiantesPorEdad() {
		
		Students instance = new Students(STUDENTS);	
		
		List<Student> estudiantes = instance.listEstudiantesPorEdad();
		assertEquals(estudiantes.size(), 3);
	}
	
	

}
