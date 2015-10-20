package lab13;

import java.util.Random;
public class SecretWord {
	
	String[] secretWords = {"machine", "learning", "capability", "understanding"};
	String hintWord;
	String secretWord;
	int numberOfTurns;
	
	public SecretWord() {
		this.secretWord = initializeSecretWord();
		this.hintWord = initializeHintWord(secretWord.length());
		this.numberOfTurns = 0;
	}
	
	String  initializeSecretWord() {
		Random rand = new Random();
		String randPickedWord = secretWords[rand.nextInt(secretWords.length)].toLowerCase();
		
		return randPickedWord;
	}
	
	String initializeHintWord(int len) {
		String initialHint = "";
		for (int i = 0; i < len; i++) {
			initialHint += "*";
		}
		return initialHint;
	}
	
	public String getHintWord() {
		
		return this.hintWord;
	}

	public int getNumberOfTurns() {
		return this.numberOfTurns;
	}

	public String getSecretWord() {
		
		return this.secretWord;
	}

	public void guessLetter(char guess) {
		// update hintWord
		// replace uncover corresponding characters if the guess is correct
		for (int i = 0; i < this.secretWord.length(); i++) {
			if (this.secretWord.charAt(i) == guess) {
				this.hintWord = this.hintWord.substring(0, i) + guess + this.hintWord.substring(i + 1);
			}
		}
	}

	public void setNumberOfTurns(int num) {
		this.numberOfTurns = num;
	}

}
