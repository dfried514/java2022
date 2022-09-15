package com.friedman.tvshows.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.friedman.tvshows.models.Rating;
import com.friedman.tvshows.repositories.RatingRepository;

@Service
public class RatingService {

	@Autowired
	private RatingRepository ratingRepo;
	
	public List<Rating> allRatingsForShow(Long id) {
		return ratingRepo.findAllByShowId(id);
	}
	public List<Rating> allRatinginsForShowAndUser(Long showId, Long userId) {
		return ratingRepo.findAllByShowIdAndUserId(showId, userId);
	}
	public List<Double> averageRatings() {
		return ratingRepo.averageRatings();
	}
	public Rating createRating(Rating rating) {
		return ratingRepo.save(rating);
	}
}

