package summer.camp1.just.hangman.service;

import summer.camp1.just.hangman.model.Game;
import summer.camp1.just.hangman.model.User;

public interface GameService {
	Game create(User user);
	Game guess(Game game, String guessWord);
}
