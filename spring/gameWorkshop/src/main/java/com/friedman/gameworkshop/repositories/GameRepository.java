package com.friedman.gameworkshop.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.friedman.gameworkshop.models.Game;


public interface GameRepository extends CrudRepository<Game, Long> {

	List<Game> findAll();
	
	Optional<Game> findById(Long id);
	
	Optional<Game> findByName(String name);
}
