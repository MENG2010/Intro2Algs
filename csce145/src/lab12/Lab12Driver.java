package lab12;
/*
 * Written by JJ Shepherd
 * 
 */
public class Lab12Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Creates a new instance of a grader
		Grader g = new Grader();
		//Collects the grade information
		g.setQuiz1();
		g.setQuiz2();
		g.setMidtermExam();
		g.setFinalExam();
		//Calculates the final grade
		g.calculateFinalGrade();
		//Prints the results to the user
		g.printFinalGrade();
	}

}