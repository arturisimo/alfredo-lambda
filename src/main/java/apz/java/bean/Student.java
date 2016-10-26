package apz.java.bean;

import java.util.Comparator;

public class Student {
	   private int id;
	   private int age;
	   private Sex gender;
	   private String fname;
	   private double cgpa;
	   
	   public enum Sex {
	        MALE, FEMALE
	    }
	   
	   /**
		 * @param id
		 * @param age
		 * @param gender
		 * @param fname
		 * @param cgpa
		 */
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
	   public String getFname() {
	      return fname;
	   }
	   public double getCgpa() {
	      return cgpa;
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
	
	public static Comparator<Student> getComparator() {   
		   
		   Comparator<Student> comp = new Comparator<Student>(){
			   
			   @Override
		       public int compare(Student a, Student b) {
		           if (a.getCgpa() > b.getCgpa()) {
		        	   return -1;
		           } else if (a.getCgpa() < b.getCgpa()) {
		        	   return 1;
			   	   }
				   return a.getFname().compareTo(b.getFname());
		       }
			   
		   };
		   
		   return comp;
	   }
}