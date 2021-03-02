package org.apz.collections.pojo;


public class Student {
	
	private int id;
	private int age;
	private Sex gender;
	private String fname;
	private double cgpa;
	   
	public enum Sex {
	        MALE, FEMALE
	}
	   
	
	public Student(int id, int age, Sex gender, String fname, double cgpa) {
	      super();
	      this.id = id;
	      this.age = age;
	      this.gender = gender;
	      this.fname = fname;
	      this.cgpa = cgpa;
	}
	  
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public double getCgpa() {
		return cgpa;
	}
	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the gender
	 */
	public Sex getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(Sex gender) {
		this.gender = gender;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student [id=" + id + ", age=" + age + ", fname=" + fname
				+ ", cgpa=" + cgpa + "]";
	}
	
	public static int compareAges(Student st1, Student st2){
		return ((Integer) st1.getAge()).compareTo(st2.getAge());
	}
}