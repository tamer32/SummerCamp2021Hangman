package summer.camp1.just.hangman.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import summer.camp1.just.hangman.model.Game;
import summer.camp1.just.hangman.model.User;
import summer.camp1.just.hangman.service.GameService;

@Controller
public class MyFirstDemoController {
	
	@Autowired
	private GameService gameService;

	@GetMapping("/")
	public String testController() {
		return "index.html";
	}
	
	@PostMapping(value = "/create", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String register(@ModelAttribute User user, Model model) {	
		Game game = gameService.create(user);
		model.addAttribute("currentWord",game.getCurrWord());
		model.addAttribute("remainingChars", game.getRemainingChars());
		return "gameScreen.html";
	}
	
	@PostMapping(value = "/guess", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String guessTheWord(@ModelAttribute Game game, Model model, @ModelAttribute String guessWord, Model word) {	
		word.getAttribute("guessWord");
		Game updatedGame =gameService.guess(game, guessWord);
		model.addAttribute("currentWord",game.getCurrWord());
		model.addAttribute("remainingChars", game.getRemainingChars());
		return "gameScreen.html";
	}
	
}
