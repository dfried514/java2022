package com.friedman.gameworkshop.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.friedman.gameworkshop.models.Game;
import com.friedman.gameworkshop.models.GameMechanic;

public interface GameMechanicRepository extends CrudRepository<GameMechanic, Long> {
	
	List<GameMechanic> findAll();
	
	List<GameMechanic> findAllByGameIdIs(Long id);
	
	List<GameMechanic> findAllByGameIdIsNot(Long id);
	
	Optional<GameMechanic> findById(Long id);
	
}
