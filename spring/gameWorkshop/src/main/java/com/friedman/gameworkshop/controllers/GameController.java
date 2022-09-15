package com.friedman.gameworkshop.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.friedman.gameworkshop.models.Game;
import com.friedman.gameworkshop.models.User;
import com.friedman.gameworkshop.services.GameService;
import com.friedman.gameworkshop.services.UserService;

@Controller
public class GameController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private GameService gameService;
	
	@GetMapping("/home")
	public String home(Model model, HttpSession session) {
		Long userId = (Long)session.getAttribute("userId");
		if (userId == null)
			return "redirect:/";
		User user = userService.findUser(userId);
		if (user == null)
			return "redirect:/";
		model.addAttribute("user", user);
		List<Game> games = gameService.allGames();
		model.addAttribute("games", games);
		return "home.jsp";
	}
	
	@GetMapping("/games/new")
	public String newGame(@ModelAttribute("game") Game game, Model model, HttpSession session) {
		Long userId = (Long)session.getAttribute("userId");
		if (userId == null)
			return "redirect:/";
		User user = userService.findUser(userId);
		if (user == null)
			return "redirect:/";
		model.addAttribute("user", user);
		return "newGame.jsp";
	}
	
	@GetMapping("/games/{gameId}")
	public String getGame(@PathVariable("gameId") Long gameId, Model model, HttpSession session) {
		Long userId = (Long)session.getAttribute("userId");
		if (userId == null)
			return "redirect:/";
		User user = userService.findUser(userId);
		if (user == null)
			return "redirect:/";
		model.addAttribute("user", user);
		Game game = gameService.findGame(gameId);
		model.addAttribute("game", game);
		return "game.jsp";
	}
	
	@GetMapping("/games/edit/{id}")
	public String editGame(@PathVariable("id") Long id, Model model, HttpSession session) {
		Long userId = (Long)session.getAttribute("userId");
		if (userId == null)
			return "redirect:/";
		User user = userService.findUser(userId);
		if (user == null)
			return "redirect:/";
		model.addAttribute("user", user);
		Game game = gameService.findGame(id);
		model.addAttribute("game", game);
		return "editGame.jsp";
	}
	
	@RequestMapping(value="/games/edit/{id}", method=RequestMethod.PUT)
	public String updateGame(@PathVariable("id") Long id, 
			@Valid @ModelAttribute("game") Game game, BindingResult result, HttpSession session) {
		Long userId = (Long)session.getAttribute("userId");
		if (userId == null)
			return "redirect:/";
		User user = userService.findUser(userId);
		if (user == null)
			return "redirect:/";
		if (result.hasErrors())
			return "editGame.jsp";
		gameService.updateGame(id, game, result);
		if (result.hasErrors())
			return "editGame.jsp";
		return "redirect:/home";	
	}
	
	@PostMapping("/games/new")
	public String createGame(@Valid @ModelAttribute("game") Game game, BindingResult result,
			HttpSession session) {
		Long userId = (Long)session.getAttribute("userId");
		if (userId == null)
			return "redirect:/";
		User user = userService.findUser(userId);
		if (user == null)
			return "redirect:/";
		if (result.hasErrors())
			return "newProject.jsp";
		gameService.createGame(game, result);
		if (result.hasErrors())
			return "newGame.jsp";
		return "redirect:/home";
	}
	
	@PostMapping("/games/create")
	public String getCreateGame(HttpSession session) {
		Long userId = (Long)session.getAttribute("userId");
		if (userId == null)
			return "redirect:/";
		User user = userService.findUser(userId);
		if (user == null)
			return "redirect:/";
		return "redirect:/games/new";
	}
	
	@RequestMapping(value="/games/delete/{gameId}")
	public String destroy(@PathVariable("gameId") Long gameId, HttpSession session) {
		Long userId = (Long)session.getAttribute("userId");
		if (userId == null)
			return "redirect:/";
		User user = userService.findUser(userId);
		if (user == null)
			return "redirect:/";
		gameService.deleteGame(gameId);
		return "redirect:/home";
	} 
}
