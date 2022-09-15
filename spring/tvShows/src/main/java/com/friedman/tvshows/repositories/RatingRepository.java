package com.friedman.tvshows.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.friedman.tvshows.models.Rating;


@Repository
public interface RatingRepository extends CrudRepository<Rating, Long> {
	
	List<Rating> findAll();
	
	List<Rating> findAllByShowId(Long id);
	
	List<Rating> findAllByShowIdAndUserId(Long showId, Long userId);
	
	@Query(value = "SELECT avg(value) FROM Rating GROUP BY show_id")
	public List<Double> averageRatings();
}
