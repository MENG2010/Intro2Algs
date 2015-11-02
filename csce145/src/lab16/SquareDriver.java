package lab16;

import java.util.*;
public class SquareDriver {
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		String input ="";
		System.out.println("Welcome to the easy square program");
		while(true)
		{
			System.out.println("Enter the length of the side of a square or enter QUIT to quit");
			try
			{
				input = keyboard.nextLine();
				if(input.equalsIgnoreCase("quit"))
					break;
				int length = Integer.parseInt(input);
				Square s = new Square();
				s.setLength(length);
				s.draw();
				System.out.println("The area is "+s.getArea());
				System.out.println("The perimeter is "+s.getPerimeter());
			}
			catch(DimensionException e)
			{
				System.out.println(e.getMessage());
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
}
