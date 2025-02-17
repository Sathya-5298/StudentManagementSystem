package com.qa.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main3 {

	private static List<Student> studentList;

	public static void main(String[] args) {
		System.out.println("****** Student Management System ******");
		System.out.println("***** Welcome *****");

		studentList = new ArrayList<Student>();
		
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter Student Name...");
		String name = scn.next();
		System.out.println(name);
		System.out.println("Enter Student Age...");
		int age = scn.nextInt();
		System.out.println(age);
		
		
		scn.close();
		
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
