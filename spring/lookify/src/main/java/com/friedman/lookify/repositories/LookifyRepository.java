package com.friedman.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.friedman.lookify.models.Song;

@Repository
public interface LookifyRepository extends CrudRepository<Song, Long> {
	List<Song> findAll();
	
	List<Song> findByArtistContaining(String infix);
	
	List<Song> findTop10ByOrderByRatingDesc();
	
	void deleteById(Long id);
}
