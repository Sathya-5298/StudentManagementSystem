package com.qa.studentapp;

public class Main {

	public static void main(String[] args) 
	{
		System.out.println("****** Student Management System ******");
		System.out.println("***** Welcome *****");
		
		Student s1;
		s1 = new Student("Rohith Shetty",25,"S-52");
		s1.enrollCourse("Java");
		s1.enrollCourse("dsa");
		s1.enrollCourse("Testing");
		s1.displayStudentInfo();
		// System.out.println(s1);
		
		Student s2 = new Student("Virat Singh", 22, "S-11");
		s2.enrollCourse("DSA");
		s2.displayStudentInfo();
		// System.out.println(s2);
		
		Student s3 = new Student("Ritu Sarma", 27, "S-12");
		s3.enrollCourse("Devops");
		s3.displayStudentInfo();
		// System.out.println(s3);
		
	}

}
