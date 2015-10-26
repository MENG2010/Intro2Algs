package lab14;

import java.util.regex.Pattern;

public class Employee {
	private String name;
	private double salary;
	private String hireDate;
	private int idNumber;
	
	// default constructor
	public Employee() {
		this.name = "no name yet";
		this.salary = 0;
		this.hireDate = "in processing ...";
		this.idNumber = -1;
	}
	public Employee(String name, double salary, String hireDate, int idNumber) {
		setName(name);
		setSalary(salary);
//		setHireDate(hireDate); // check with regex
		setHiringDate(hireDate); // check mm, dd, yyyy separately
		setIdNumber(idNumber);
		
		if (this.name == null || this.salary < 0 || this.hireDate == null || this.idNumber < 0) {
			System.err.println(">>> Invalid Inputs! End! <<<");
			System.exit(0);
		}
	}

	public void writeOutput() {
		System.out.println("Name:\t" + this.name 
											+ "\nSalary:\t" + this.salary
											+ "\nHire Date:\t" + this.hireDate
											+ "\nEmployee Id:\t" + this.idNumber);
		
	}
	
	public boolean equals(Employee toCompare) {
		return ( this.name.equalsIgnoreCase(toCompare.name) 
								&& this.salary == toCompare.salary
								&& this.hireDate.equals(toCompare.hireDate)
								&& this.idNumber == toCompare.idNumber);
	}
	
	// gets and sets
	public String getName() {
		return this.name;
	}
	
	public double salary() {
		return this.salary;
	}
	
	public String getHireDate() {
		return this.hireDate;
	}
	
	public int getIdNumber() {
		return this.idNumber;
	}
	
	public void setName(String name) {
		if (name == null || name.trim().length() == 0) {
			// NULL or empty string
			System.err.println("Invalid name!");
			this.name = null;
			return;
		}
		this.name = name;
	}
	
	public void setSalary(double salary) {
		if (salary < 0) {
			System.err.println("Invalid salary! It MUST NOT be less than 0!");
			this.salary = -1;
			return;
		}
		this.salary = salary;
	}
	
	// verify Date with regex.
	public void setHireDate(String hireDate) {
		String regEx = "(0|1)[0-9]/[0-3][0-9]/(19|20)[0-9]{2}"; // date format: mm/dd/yyyy
		Pattern pattern = Pattern.compile(regEx);
		
		if (hireDate == null || ! (pattern.matcher(hireDate).matches()) ) {
			// NULL or invalid format.
			System.err.println("Invalid hire date! Date format should be \"mm/dd/yyyy.\"");
			this.hireDate = null;
			return;
		}
		this.hireDate = hireDate;
	}
	
	// verify Date by IF-ELSE blocks
	public void setHiringDate(String hireDate) {
		if (hireDate == null) {
			System.err.println("Invalid hire date!");
			this.hireDate = null;
			return;
		}
		int m = Integer.valueOf(hireDate.substring(0, hireDate.indexOf("/")));
		int d = Integer.valueOf(hireDate.substring(hireDate.indexOf("/") + 1, hireDate.lastIndexOf("/")));
		int y = Integer.valueOf(hireDate.substring(hireDate.lastIndexOf("/") + 1));
		
		if (m < 1 || m > 12
				|| d < 1 || d > 31
				|| y < 1900 || y > 2016) {
			// invalid date
			System.err.println("Invalid hire date!");
			this.hireDate = null;
			return;
		}
		this.hireDate = hireDate;
	}
	
	public void setIdNumber(int idNumber) {
		if (idNumber <= 0) {
			// id starts from 1
			System.err.println("Id number starts from 1.");
			this.idNumber = -1;
			return;
		}
		this.idNumber = idNumber;
	}
}
