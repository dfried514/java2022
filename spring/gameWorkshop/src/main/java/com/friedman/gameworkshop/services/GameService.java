package com.friedman.gameworkshop.services;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.friedman.gameworkshop.models.Game;
import com.friedman.gameworkshop.repositories.GameRepository;


@Service
public class GameService {

	@Autowired
	private GameRepository gameRepo;
	
	public List<Game> allGames() {
		List<Game> games = gameRepo.findAll();
		Collections.sort(games);
		return games;
	}
	public Game createGame(Game game, BindingResult result) {
		Optional<Game> optionalGameByName = gameRepo.findByName(game.getName());
		if (optionalGameByName.isPresent()) {
			result.rejectValue("name", "duplicateName", "Name of game is already taken!");
			return null;
		}
		return gameRepo.save(game);
	}
	public Game findGame(Long id) {
		Optional<Game> optionalGame = gameRepo.findById(id);
		if (optionalGame.isPresent())
			return optionalGame.get();
		return null;
	}
	public Game updateGame(Long id, Game game, BindingResult result) {
		Optional<Game> optionalGameById = gameRepo.findById(id);
		if (optionalGameById.isPresent()) {
			Optional<Game> optionalGameByName = gameRepo.findByName(game.getName());
			if (optionalGameByName.isPresent()) {
				if (optionalGameByName.get().getId() != game.getId()) {
					result.rejectValue("name", "duplicateName", "Name of game is already taken!");
					return null;
				}	
			}
			game.setId(id);
			return gameRepo.save(game);
		}
		return null;
	}
	public void deleteGame(Long id) {
		gameRepo.deleteById(id);
	}
}


	