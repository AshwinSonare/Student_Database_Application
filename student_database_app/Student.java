package student_database_app;

import java.util.Scanner;

public class Student {
	private String firstName;
	private String lastName;
	private int gradeYear;
	private String studentID;
	private String courses = " ";
	private int tuitionBalance = 0;
	private static int costOfCourse = 600;
	private static int id = 1001;
	
	// Constructor : prompt user to enter Student's name and year
	public Student() {
		Scanner in = new Scanner(System.in);
		System.out.print("\nEnter student's first name :");
		this.firstName = in.nextLine();
		
		System.out.print("Enter student's last name :");
		this.lastName = in.nextLine();
		
		System.out.print("1 for FY\n2 for SY\n3 for TY\n4 for BTech\n Enter Student's class:");
		this.gradeYear = in.nextInt();
		
		setStudentID();
	}
	
	// Generate ID
	private void setStudentID()
	{
		// Grade Level + ID
		id++;
		this.studentID = gradeYear + "" + id;
	}
	
	// Enroll in courses
	public void enroll()
	{
		// Get inside loop, user hits 0
		do{
			System.out.print("\nEnter course to enroll (Q to quit):");
		    Scanner in =  new Scanner(System.in);
		    String course = in.nextLine();
		    if(!course.equals("Q"))
		    {
			    courses = courses + "\n " + course;
			    tuitionBalance = tuitionBalance + costOfCourse;
		    }
		    else 
		    {
		    	System.out.print("BREAK!");
		    	break;
		    }
		}while(1 != 0);
	}
	
	// View balance
	public void viewBalance()
	{
		System.out.print("\nYour balance is Rs." + tuitionBalance);
	}
	
	// Pay tuition
	public void payTuition()
	{
		viewBalance();
		System.out.print("\nEnter your payment: Rs.");
		Scanner in = new Scanner(System.in);
		int payment = in.nextInt();
		tuitionBalance = tuitionBalance - payment;
		System.out.print("\nThank you for your payment of Rs." + payment);
		viewBalance();
	}
	
	// Show status
	public String toString()
	{
		return "\nName :" + firstName + " " + lastName +
			   "\nGrade level: " + gradeYear +
			   "\nStudent ID: " + studentID +
			   "\nCourses Enrolled:" + courses +
			   "\nBalance : Rs." + tuitionBalance;
	}
}
