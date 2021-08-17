package summer.camp1.just.hangman.model;

import java.util.List;

public class Game {
	private String currWord;
	private User user;
	private List<Character> remainingChars;
	
	public String getCurrWord() {
		return currWord;
	}
	public void setCurrWord(String currWord) {
		this.currWord = currWord;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Character> getRemainingChars() {
		return remainingChars;
	}
	public void setRemainingChars(List<Character> remainingChars) {
		this.remainingChars = remainingChars;
	}
}
