package com.friedman.tvshows.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.friedman.tvshows.models.Show;


public interface ShowRepository extends CrudRepository<Show, Long> {

	List<Show> findAll();
	
	Optional<Show> findById(Long id);
	
	Optional<Show> findByTitle(String title);
}
