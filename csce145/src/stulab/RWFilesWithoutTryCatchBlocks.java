package stulab;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class RWFilesWithoutTryCatchBlocks {
	// the method that invokes methods throwing exceptions has to throw the same exception as well
	// by adding throws xxxException in the method head
	public static void main(String[] args) throws FileNotFoundException, IOException{
		RWFilesWithoutTryCatchBlocks fileHandler = new RWFilesWithoutTryCatchBlocks();
		
		// reference regarding path:
		// https://docs.oracle.com/javase/tutorial/essential/io/path.html
		// https://docs.oracle.com/javase/tutorial/essential/io/pathOps.html
		
		// examples with ABSOLUTE path
		// absolute path allows you to access files locate in any place in your operating system
		// note: the project is under folders "/home/meng/git/Intro2Algs/csce145/"
		fileHandler.anotherWay2ReadAFile("/home/meng/documents/testing/file_in_somewhere_else.txt");
		fileHandler.anotherWay2WriteAFile("/home/meng/documents/testing/file_in_somewhere_else.txt");
		
	}
	
	// read a file without a try-catch block
	public void anotherWay2ReadAFile (String fileName) throws FileNotFoundException {
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
	}
	
	// write a file without a try-catch block
	public void anotherWay2WriteAFile (String fileName) throws IOException, FileNotFoundException {
		boolean append = true;
		// We don't want to erase the original content in the file
		// so we choose to add new outputs to the end of the file, by setting the 2nd parameter to true
		// otherwise (the 2nd parameter is false or not provided), the original contents in the file will be erased
		PrintWriter filePrinter = new PrintWriter(new FileOutputStream(fileName), append);
		filePrinter.println("A new line to file_in_somewhere_else.txt");
		// close the file after done writing
		// new contents will not in the file if we do not close it
		filePrinter.close();
	}
}
