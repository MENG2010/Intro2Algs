package lab13;
import java.util.Scanner;
public class SecretWordGame {

	//Creates a constant for the number of tries in this game
	public static final int NUM_TRIES = 5;
	public static void main(String[] args) {
		
		//Creates the object for user input
		Scanner keyboard = new Scanner(System.in);
		
		//Starts the overall game
		boolean quit = false;
		while(quit == false)
		{
			//Starts the main game loop
			System.out.println("Welcome to the word guessing game! You have "+NUM_TRIES+" tries to guess the secret word!");
			SecretWord sWord = new SecretWord();
			System.out.println("The current hint is\n "+sWord.getHintWord());
			while(sWord.getNumberOfTurns()<NUM_TRIES)
			{
				System.out.println("Guess a lowercase letter, you have " + (NUM_TRIES - sWord.getNumberOfTurns()) + " more times");
				
				//Gets the first letter of whatever is entered into the console
				char guess = keyboard.nextLine().charAt(0);
				
				//Calls the guessLetter method from secret word to update the hint
				sWord.guessLetter(guess);
				
				System.out.println(sWord.getHintWord());
				
				System.out.println("Guess the secret word");
				
				String sGuess = keyboard.nextLine();
				//Checks to see if the guess was correct
				if(sGuess.equals(sWord.getSecretWord()))
				{
					System.out.println("You win!");
					break;
				}
				else
				{
					System.out.println("Keep trying!");
				}
				sWord.setNumberOfTurns(sWord.getNumberOfTurns()+1);
			}
			//Prompts the user to play again
			System.out.println("Game over!  Would you like to try again?");
			String input = keyboard.nextLine();
			if(input.equalsIgnoreCase("no"))
			{
				quit = true;
			}
			else
			{
				System.out.println("Let's go again!");
			}
		}
		System.out.println("Goodbye!");
	}

}