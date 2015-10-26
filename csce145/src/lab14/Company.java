package lab14;

import java.util.*;
public class Company {

	/**
	 * @param args
	 */
	private Employee[] employees;
	private static final int MAX_EMPLOYEES = 10;
	private int currEmployees;
	static Scanner keyboard = new Scanner(System.in);
	public Company()
	{
		this.employees = new Employee[MAX_EMPLOYEES];
		this.currEmployees = 0;
	}
	/*
	 * Adds a new employee to the array
	 */
	public void Hire()
	{
		//If the company is full then it cannot hire anymore
		if(currEmployees>=MAX_EMPLOYEES)
		{
			System.out.println("The company is no longer hiring");
			return;
		}
		
		//Gets the information about the new employee
		String name;
		String hireDate;
		double salary;
		int idNumber;
		System.out.println("Enter their name ");
		name = keyboard.nextLine();
		System.out.println("Enter their hire date ");
		hireDate = keyboard.nextLine();
		System.out.println("Enter thier salary ");
		salary = keyboard.nextDouble();
		System.out.println("Enter the employee number");
		idNumber = keyboard.nextInt();
		//Creates a new instance of an employee.
		Employee newEmployee = new Employee(name,salary,hireDate,idNumber);
		newEmployee.writeOutput();
		//Adds the new employee to the list
		employees[currEmployees] = newEmployee;
		//Increases the current number of employees
		currEmployees++;
	}
	public void LookUpEmployee(int idNumber)
	{
		if(idNumber<0||idNumber>=MAX_EMPLOYEES)
		{
			System.out.println("Invalid id number!");
		}
		else
		{
			employees[idNumber].writeOutput();
		}
	}
	public void CompareEmployees(int index1, int index2)
	{
		if(employees[index1].equals(employees[index2]))
		{
			System.out.println("These employees are the same!");
		}
		else
		{
			System.out.println("These employees are the different!");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Create a new instance of a company
		Company c = new Company();
		//prompt the user
		System.out.println("Welcome to the Company Management Software!");
		boolean quit = false;
		int input = 0;
		while(quit == false)
		{
			//Prompt the user
			System.out.println("What would you like to do?");
			System.out.println("1. Hire a new employee");
			System.out.println("2. Look up information on an employee");
			System.out.println("3. Compare two employees");
			System.out.println("4. Quit");
			//Get the input
			input = keyboard.nextInt();
			keyboard.nextLine();
			switch(input)
			{
			case 1:
				c.Hire();
				break;
			case 2:
				System.out.println("Enter the index number of the employee");
				input = keyboard.nextInt();
				c.LookUpEmployee(input);
				break;
			case 3:
				System.out.println("Enter the two indices corresponding to the employees");
				c.CompareEmployees(keyboard.nextInt(), keyboard.nextInt());
				break;
			case 4:
				quit = true;
				break;
			default:
				System.out.println("Invalid input");
				break;
			}
		}

	}

}
