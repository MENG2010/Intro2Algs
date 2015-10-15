package lab12;

import java.util.Scanner;

public class Grader {
	private double quiz1;
	private double quiz2;
	private double midtermExam;
	private double finalExam;
	private double finalGrade;
	private String letterGrade;
	
	private Scanner sc = new Scanner(System.in);
	
	public void setQuiz1() {
		System.out.println("enter score of quiz1 (0 - 100):");
		quiz1 = sc.nextDouble();
		if (!(0 <= quiz1 && quiz1 <= 100)) {
			System.out.println("Invalid score!");
			System.exit(0);
		} 
		
	}
	
	public void setQuiz2() {
		System.out.println("enter score of quiz2 (0 - 100):");
		quiz2 = sc.nextDouble();
		if (!(0 <= quiz2 && quiz2 <= 100)) {
			System.out.println("Invalid score!");
			System.exit(0);
		} 
	}
	
	public void setMidtermExam() {
		System.out.println("enter score of midterm exam (0 - 100):");
		midtermExam = sc.nextDouble();
		if (!(0 <= midtermExam && midtermExam <= 100)) {
			System.out.println("Invalid score!");
			System.exit(0);
		}
	}
	
	public void setFinalExam() {
		System.out.println("enter score of final exam (0 - 100):");
		finalExam = sc.nextDouble();
		if (!(0 <= finalExam && finalExam <= 100)) {
			System.out.println("Invalid score!");
			System.exit(0);
		}
	}
	
	/*
	 * calculateFinalGrade:
	 * 		- Each quiz is worth 12.5%
	 * 		- The midterm is worth 25%
	 * 		- The final is worth 50%
	 * letter grade:
	 * 		- 90+  A
	 *		- 80-89 B
	 * 		- 70-79 C
 	 *		- 60-69 D
	 *		- <60 F
	 */
	public void calculateFinalGrade() {
		finalGrade = quiz1 * 0.125 + quiz2 * 0.125
					+ midtermExam * 0.25 + finalExam * 0.5;
		// letter grade
		if (finalGrade > 89) {
			letterGrade = "A";
		} else if (finalGrade > 79) {
			letterGrade = "B";
		} else if (finalGrade > 69) {
			letterGrade = "C";
		} else if (finalGrade > 59) {
			letterGrade = "D";
		} else {
			letterGrade = "F";
		}
	}
	
	public void printFinalGrade() {
		System.out.println("The final grade is \n" + finalGrade + "\n" + letterGrade);
	}
}
