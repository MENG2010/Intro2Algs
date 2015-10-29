package lab15;

import java.util.*;
public class DiamondDrawer {
	public static void main(String[]args)
	{
		System.out.println("Welcome to the diamond drawer");
		Scanner keyboard = new Scanner(System.in);
		boolean quit = false;
		while(quit == false)
		{
			//Prompt the user
			System.out.println("Enter the diamond size followed by the offset or 0 to quit");
			//Get the inputs
			int width = keyboard.nextInt();
			int offset = keyboard.nextInt();
			//Check if the user wants to quit
			if(width ==0 || offset == 0)
			{
				System.out.println("bye!");
				break;
			}
			//Draw the diamond
			Diamond d = new Diamond(width,offset);
			d.drawHere();
		}
	}
}
