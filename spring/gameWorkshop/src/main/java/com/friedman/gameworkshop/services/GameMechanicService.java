package com.friedman.gameworkshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.friedman.gameworkshop.models.GameMechanic;
import com.friedman.gameworkshop.repositories.GameMechanicRepository;

@Service
public class GameMechanicService {

	@Autowired
	private GameMechanicRepository gameMechanicRepo;
	
	public List<GameMechanic> allGameMechanics() {
		return gameMechanicRepo.findAll();
	}
	public List<GameMechanic> allGameMechanicsBelongingToGame(Long id) {
		return gameMechanicRepo.findAllByGameIdIs(id);
	}
	public List<GameMechanic> allGameMechanicsNotBelongingToGame(Long id) {
		return gameMechanicRepo.findAllByGameIdIsNot(id);
	}
	public void deleteGameMechanic(Long id) {
		Optional<GameMechanic> optionalGameMechanic = gameMechanicRepo.findById(id);
		if (optionalGameMechanic.isPresent()) {
			gameMechanicRepo.deleteById(id);
		}
	}
	public GameMechanic createGameMechanic(GameMechanic gameMechanic) {
		return gameMechanicRepo.save(gameMechanic);
	}
	
}
