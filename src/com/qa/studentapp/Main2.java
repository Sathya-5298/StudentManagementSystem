package com.qa.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main2 {

	private static List<Student> studentList;

	public static void main(String[] args) {
		System.out.println("****** Student Management System ******");
		System.out.println("***** Welcome *****");

		studentList = new ArrayList<Student>();

		Student s1;
		s1 = new Student("Aripit Shetty", 25, "S-52");
		s1.enrollCourse("Java");
		s1.enrollCourse("dsa");
		s1.enrollCourse("Testing");

		Student s2 = new Student("Virat Singh", 22, "S-11");
		s2.enrollCourse("DSA");

		Student s3 = new Student("Ritu Sarma", 27, "S-12");
		s3.enrollCourse("Devops");

		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);

		Student result = findStudentById("S-12");
		System.out.println("Result -  " + result);
		
		sortByName();

	}

	private static void sortByName() 
	{
		Comparator<Student> studentNameComparator = (o1,o2) -> o1.getName().compareTo(o2.getName());
		/*
		 * Comparator<Student> studentNameComparator = new Comparator<Student>() {
		 * 
		 * @Override public int compare(Student o1, Student o2) { return
		 * o1.getName().compareTo(o2.getName()); // Comparing will happen
		 * Lexographically } };
		 */
		
		Collections.sort(studentList,studentNameComparator);
		System.out.println("Sorted Student List is " + studentList);
	}

	public static Student findStudentById(String studentId) {
		Student result = null;
		try {
			result = studentList.stream().filter(x -> x.getStudentId().equalsIgnoreCase(studentId)).findFirst()
					.orElseThrow(() -> new RuntimeException("No data found!!"));
		} catch (RuntimeException e) {
			System.err.println("Student with Id " + studentId + " not found in system!!");
		}
		return result;
	}

}
