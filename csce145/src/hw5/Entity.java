package hw5;

/**
 * @author meng (y.meng201011@gmail.com)
 * homework 5 of csce 145
 * entities
 */
public enum Entity {
	EMPTY, PLAYER, ICECREAM, MINE;
	
	@Override
	public String toString() {
		String entity = "";
		switch (this) {
		case EMPTY:
			entity = "_";
			break;
		case PLAYER:
			entity = "X";
			break;
		case ICECREAM:
			entity = "^";
			break;
		case MINE:
			entity = "_";
			break;
		}
		
		return entity;
	}
}
