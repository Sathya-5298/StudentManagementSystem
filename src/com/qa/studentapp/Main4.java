package com.qa.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main4 {

	private static List<Student> studentList;
	private static Scanner scn;

	public static void main(String[] args) {
		System.out.println("****** Student Management System ******");

		studentList = new ArrayList<Student>();
		scn = new Scanner(System.in);
		while (true) {
			System.out.println("***** Welcome *****");

			System.out.println("Select an option....");
			System.out.println("1. Register a Student");
			System.out.println("2. Find a Student with studentId");
			System.out.println("3. List all Student Information");
			System.out.println("4. List Sudent Information in sorted order");
			System.out.println("5. Exit");
			int option = scn.nextInt();

			switch (option) {
			case 1:
				enrollStudent(scn);
				break;
			case 2:
				findStudentById(scn);
				break;
			case 3:
				printAllStudentsData();
				break;
			case 4:
				sortByName();
				break;
			case 5:
				exit();
				break;
			default:
				System.out.println("Invalid Option selected!!");

			}
		}

	}

	private static void exit() 
	{
		
		System.exit(0);
	}

	private static void printAllStudentsData() {
		if (studentList.size() > 0) {
			System.out.println("--------Print All Students Data--------");
			for (Student student : studentList) {
				student.displayStudentInfo();
			}
			System.out.println("--------Printed All Students Data--------");
		} else {
			System.err.println("Student List is empty and No records found!!");
		}
	}

	private static void findStudentById(Scanner scn2) 
	{
		Student studentFound = null;
		System.out.println("Enter StudentId");
		String studentId = scn2.next();
		try {
			studentFound = studentList.stream().filter(student -> student.getStudentId().equalsIgnoreCase(studentId)).findFirst()
					.orElseThrow(() -> new RuntimeException("No data found!!"));
		} catch (RuntimeException e) {
			System.err.println("Student with Id " + studentId + " not found in system!!");
		}
		
		studentFound.displayStudentInfo();
	}

	private static void enrollStudent(Scanner scn2) {
		System.out.println("Enter Student Name");
		String studentName = scn2.next();

		System.out.println("Enter Student Age");
		int studentAge = scn2.nextInt();

		System.out.println("Enter Student Id");
		String studentId = scn2.next();

		Student newStudent = new Student(studentName, studentAge, studentId);
		studentList.add(newStudent);

		while (true) {
			System.out.println("Enter the course to enrolled");
			String courseName = scn2.next();
			if (courseName.equalsIgnoreCase("done")) {
				break;
			}
			newStudent.enrollCourse(courseName);
		}
		newStudent.displayStudentInfo();
	}

	private static void sortByName() {
		Comparator<Student> studentNameComparator = (o1, o2) -> o1.getName().compareTo(o2.getName());
		/*
		 * Comparator<Student> studentNameComparator = new Comparator<Student>() {
		 * 
		 * @Override public int compare(Student o1, Student o2) { return
		 * o1.getName().compareTo(o2.getName()); // Comparing will happen
		 * Lexographically } };
		 */

		Collections.sort(studentList, studentNameComparator);
		printAllStudentsData();
	}

}
