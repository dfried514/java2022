package com.friedman.tvshows.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.friedman.tvshows.models.Rating;
import com.friedman.tvshows.models.Show;
import com.friedman.tvshows.models.User;
import com.friedman.tvshows.repositories.ShowRepository;



@Service
public class ShowService {

	@Autowired
	private ShowRepository showRepo;
	
	public List<Show> allShows() {
		return showRepo.findAll();
	}
	public Show createShow(Show show, BindingResult result) {
		Optional<Show> optionalShowByTitle = showRepo.findByTitle(show.getTitle());
		if (optionalShowByTitle.isPresent()) {
			result.rejectValue("title", "duplicateTitle", "Title of show is already taken!");
			return null;
		}
		return showRepo.save(show);
	}
	public Show findShow(Long id) {
		Optional<Show> optionalShow = showRepo.findById(id);
		if (optionalShow.isPresent())
			return optionalShow.get();
		return null;
	}
	public Show updateShow(Long id, Show show, BindingResult result) {
		Optional<Show> optionalShowById = showRepo.findById(id);
		if (optionalShowById.isPresent()) {
			Optional<Show> optionalShowByTitle = showRepo.findByTitle(show.getTitle());
			if (optionalShowByTitle.isPresent()) {
				if (optionalShowByTitle.get().getId() != id) {
					result.rejectValue("title", "duplicateTitle", "Title of show is already taken!");
					return null;
				}	
			}
			show.setId(id);
			return showRepo.save(show);
		}
		return null;
	}
	public void deleteShow(Long id) {
		showRepo.deleteById(id);
	}
	public Show addRating(Long id, Rating rating) {
    	Optional<Show> optionalShow = showRepo.findById(id);
    	if (optionalShow.isPresent()) {
    		Show show = optionalShow.get();
    		show.getRatedShows().add(rating);
    		return show;
    	}
    	return null;
    }
}
