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
	
	public GameServiceImpl() {
		words.add("Riba");
		words.add("Kamionche");
		words.add("Gulub");
		words.add("Ruski");
	}

	@Override
	public Game create(User user) {
		Game game = new Game();
		game.setCurrWord(getWord());
		game.setRemainingChars(null);
		game.setUser(user);
		games.add(game);
		return game;
	}
	
	private String getWord() {
		int numberOfWords = words.size();
		Random rnd = new Random();
		return words.get(rnd.nextInt(numberOfWords-1));
	}
}
