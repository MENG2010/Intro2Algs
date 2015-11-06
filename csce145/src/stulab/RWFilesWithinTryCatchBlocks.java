package stulab;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class RWFilesWithinTryCatchBlocks {
	// Any method invokes a method that has handled exceptions with try-catch block,
	// it does not have to throw exceptions in method head
	public static void main(String[] args) {
		RWFilesWithinTryCatchBlocks fileHandler = new RWFilesWithinTryCatchBlocks();
		
		// reference regarding path:
		// https://docs.oracle.com/javase/tutorial/essential/io/path.html
		// https://docs.oracle.com/javase/tutorial/essential/io/pathOps.html
		
		// examples with RELATIVE path
		// file "file_under_pro_root.txt" locates in root folder of this project
		// therefore, there is no path info
		fileHandler.oneWay2ReadAFile("file_under_pro_root.txt");
		// this file is under a folder named "dataset" under the project
		// i.e., I created a folder "dataset" in same location of folder "src"
		// and put "file_under_dataset.txt"
		// therefore, we provide the folder name along with the file name
		fileHandler.oneWay2writeAFile("dataset/file_under_dataset.txt");	
	}
	
	// read a file within a try-catch block
	public void oneWay2ReadAFile (String fileName) {
		try {
			File fileToRead = new File(fileName);
			// create a file reader
			Scanner fileScanner = new Scanner(fileToRead);
			
			// print out the absolute path of the file
			System.out.println(fileToRead.getAbsolutePath());
			
			// print file contents into the console, line by line
			while (fileScanner.hasNext()) {
				System.out.println(fileScanner.nextLine());
			}
			
			// close the file after done reading
			fileScanner.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	// write a file within a try-catch block
	public void oneWay2writeAFile (String fileName) {
		try {
			boolean append = false;
			// in this case, we override the file every time, by setting the 2nd parameter to false
			PrintWriter filePrinter = new PrintWriter(new FileOutputStream(fileName), append);
			filePrinter.println("A new line to file_under_dataset.txt");
			filePrinter.println("This file locates under folder dataset, and the folder is in the same location as folder src");
			// close the file after done writing
			// new contents will not in the file if we do not close it
			filePrinter.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
