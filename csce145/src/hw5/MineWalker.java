package hw5;
/**
 * @author meng (y.meng201011@gmail.com)
 * homework 5 of csce 145
 * game of minewalker
 */
import java.util.Scanner;

public class MineWalker {
			
	public void walk() {
		String play = "yes";
		Board board = new Board();
		Entity[][] playboard;
		int stepX = 0, stepY = 0;
		int nextX = 0, nextY = 0;
		boolean gameover = false;
		
		while (play.equalsIgnoreCase("yes")) {
			System.out.println("input the size of board, the valid size could be 2 to 10");
			Scanner input = new Scanner(System.in);
			int boardSize = input.nextInt();
			
			if (2 <= boardSize && boardSize < 11) {
				playboard = board.initialize(boardSize);
				
				// welcome message of a new game
				System.out.println("Welcome to the game! Go get the ice cream!");
				board.printBoard();
				
				// playing
				while (!gameover) {
					// prompt to get next move
					// in x dimension
					System.out.println("Enter either a -1, 0, or 1 in the X or 9 to quit");
					stepX = input.nextInt();
					
					// quit the game
					if (stepX == 9) {
						System.out.println("GAME OVER!");
						break;
					}
					
					// normalize nextMove, stay still for invalid moves
					if (stepX < -1 || stepX > 1) {
						stepX = 0;
					}
					
					// in y dimension
					System.out.println("Enter either a -1, 0, or 1 in the Y");
					stepY = input.nextInt();
					// normalize nextMove, stay still for invalid moves
					if (stepY < -1 || stepY > 1) {
						stepY = 0;
					}
					
					// move
					nextX = board.getNextX(stepX);
					nextY = board.getNextY(stepY);
					if (playboard[nextY][nextX] == Entity.MINE) {
						// step into a mine, game over.
						System.out.println("Boom!");
						gameover = true;
					} else if (playboard[nextY][nextX] == Entity.ICECREAM) {
						// get the ice cream
						board.move(nextX, nextY);
						System.out.println("Hey, you did it!");
						board.printBoard();
						gameover = true;
					} else {
						// next location is empty, move ahead
						board.move(nextX, nextY);
						board.printBoard();
					}
				}

				
			} else {
				System.out.println("invalid board size.");
			}
			
			input.nextLine();
			System.out.println("wanna play again? yes or no?");
			play = input.nextLine();
		}

		System.out.println("Have a good day!");
	}
	
	public static void main(String[] args) {
		MineWalker walker = new MineWalker();
		walker.walk();
	}

}
