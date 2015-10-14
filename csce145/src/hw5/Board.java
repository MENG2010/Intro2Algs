package hw5;

/**
 * @author meng (y.meng201011@gmail.com)
 * homework 5 of csce 145
 * board
 */
import java.util.Random;

public class Board {
	private Entity[][] playground;
	private int size;
	
	private int playerX;
	private int playerY;
	
	public Board() {
		this.size = 10;
		this.playerX = 0;
		this.playerY = 0;
		this.playground = initialize(10);
	}
	
	// initialize the playground
	public Entity[][] initialize(int boardSize) {
		this.size = boardSize;
		Random random = new Random();
		this.playground = new Entity[this.size][this.size];
		int mineAmount = this.size * this.size / 10;
		this.playerX = 0;
		this.playerY = 0;
		int x, y;
		boolean set = false;
		
		// initialize as an empty board
		for (int col = 0; col < this.size; col++) {
			for (int row = 0; row < this.size; row++) {
				this.playground[col][row] = Entity.EMPTY;
			}
		}
		
		// place player
		this.playground[playerY][playerX] = Entity.PLAYER;
		
		
		// place icecream
		do {
			x = random.nextInt(this.size);
			y = random.nextInt(this.size);
			if (this.playground[y][x] == Entity.EMPTY) {
				this.playground[y][x] = Entity.ICECREAM;
				set = true;
			}
		} while (!set);
		
		// plant mines
		for (int i = 0; i < mineAmount; i++) {
			set = false;
			do {
				x = random.nextInt(this.size);
				y = random.nextInt(this.size);
				if (this.playground[y][x] == Entity.EMPTY) {
					this.playground[y][x] = Entity.MINE;
					set = true;
				}
			} while (!set);
		}
		
		return this.playground;
	}
	
	// move
	public void move(int nextX, int nextY) {
		System.out.println("move to " + nextX + ", " + nextY);
		// remove the player from original location
		this.playground[playerY][playerX] = Entity.EMPTY;
		// move the player to new location
		this.playground[nextY][nextX] = Entity.PLAYER;
		// update player's coordinates
		this.playerX = nextX;
		this.playerY = nextY;
	}
	
	// print board status
	public void printBoard() {
//		int size = this.playground[0].length;
		for (int col = 0; col < this.size; col++) {
			for (int row = 0; row < this.size; row++) {
				// in row
				System.out.print(this.playground[col][row]);
			}
			// start a new row
			System.out.println();
		}
	}
	
	// get next x location
	public int getNextX(int stepX) {
		// calculate next location
		int nextX = this.playerX + stepX;
		
		if (nextX < 0 || nextX >= size) {
			// reset nextX if it will go beyond the board
			nextX = this.playerX;
		} 
		
		return nextX;
	}
	
	// get next y location
	public int getNextY(int stepY) {
		// calculate next location
		int nextY = this.playerY + stepY;
		
		if (nextY < 0 || nextY >= size) {
			// reset nextY if it will go beyond the board
			nextY = this.playerY;
		}
		
		return nextY;
	}
	
}
