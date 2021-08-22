package summer.camp1.just.hangman.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

import summer.camp1.just.hangman.model.Game;
import summer.camp1.just.hangman.model.User;

@Component
public class GameServiceImpl implements GameService {
	
	List<String> words = new LinkedList<>();
	List<Game> games = new LinkedList<>();
	List<User> users = new LinkedList<>();
	
	public GameServiceImpl() {
		words.add("Riba");
		words.add("Kamionche");
		words.add("Gulub");
		words.add("Ruski");
		words.add("Maika");
	}

	@Override
	public Game create(User user) {
		Game game = new Game();
		game.setCurrWord(getWord());
		game.setRemainingChars(charsInWord(game.getCurrWord()));
		game.setRemainingChars(null);
		game.setUser(user);
		games.add(game);
		return game;
	}
	
	@Override
	public Game guess(Game game, String guessWord) {
		if(game.getCurrWord()==guessWord)
			{
			game.setRemainingChars(null);
			}
		else
			{List<Character> chars=game.getRemainingChars();
			chars.removeAll(charsInWord(guessWord));
			game.setRemainingChars(chars);
			}
		return game;
	}
	
	
	private List<Character> charsInWord(String word){
		List<Character> remainingChars=new LinkedList<>();
		for (int i=0;i<word.length();i++)
		{
			if(remainingChars.contains(word.charAt(i))==false)
			{remainingChars.add(word.charAt(i)); }
		}
		return remainingChars;
	}
	private String getWord() {
		int numberOfWords = words.size();
		Random rnd = new Random();
		return words.get(rnd.nextInt(numberOfWords-1));
	}
}
