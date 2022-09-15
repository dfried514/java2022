package com.friedman.tvshows.controllers;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.friedman.tvshows.models.Rating;
import com.friedman.tvshows.models.Show;
import com.friedman.tvshows.models.User;
import com.friedman.tvshows.services.RatingService;
import com.friedman.tvshows.services.ShowService;
import com.friedman.tvshows.services.UserService;


@Controller
public class ShowController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ShowService showService;
	
	@Autowired
	private RatingService ratingService;
	
	@GetMapping("/shows")
	public String shows(Model model, HttpSession session) {
		Long userId = (Long)session.getAttribute("userId");
		if (userId == null)
			return "redirect:/";
		User user = userService.findUser(userId);
		if (user == null)
			return "redirect:/";
		model.addAttribute("user", user);
		List<Show> shows = showService.allShows();
		model.addAttribute("shows", shows);
		List<Double> averageRatings = ratingService.averageRatings();
		model.addAttribute("averageRatings", averageRatings);
		System.out.println("first item: " + averageRatings.get(0));
		return "shows.jsp";
	}
	
	@GetMapping("/shows/new")
	public String newShow(@ModelAttribute("show") Show show, Model model, HttpSession session) {
		Long userId = (Long)session.getAttribute("userId");
		if (userId == null)
			return "redirect:/";
		User user = userService.findUser(userId);
		if (user == null)
			return "redirect:/";
		model.addAttribute("user", user);
		return "newShow.jsp";
	}
	
	@GetMapping("/shows/{showId}")
	public String getShow(@PathVariable("showId") Long showId, @ModelAttribute("rating") Rating rating, 
			Model model, HttpSession session) {
		Long userId = (Long)session.getAttribute("userId");
		if (userId == null)
			return "redirect:/";
		User user = userService.findUser(userId);
		if (user == null)
			return "redirect:/";
		model.addAttribute("user", user);
		Show show = showService.findShow(showId);
		model.addAttribute("show", show);
		List<Rating> ratings = ratingService.allRatingsForShow(showId);
		model.addAttribute("ratings", ratings);
		List<Rating> ratingsShowAndUser = ratingService.allRatinginsForShowAndUser(showId, userId);
		model.addAttribute("ratingsShowAndUser", ratingsShowAndUser);
		return "show.jsp";
	}
	
	@GetMapping("/shows/edit/{id}")
	public String editShow(@PathVariable("id") Long id, Model model, HttpSession session) {
		Long userId = (Long)session.getAttribute("userId");
		if (userId == null)
			return "redirect:/";
		User user = userService.findUser(userId);
		if (user == null)
			return "redirect:/";
		model.addAttribute("user", user);
		Show show = showService.findShow(id);
		model.addAttribute("show", show);
		return "editShow.jsp";
	}
	
	@RequestMapping(value="/shows/edit/{id}", method=RequestMethod.PUT)
	public String updateShow(@PathVariable("id") Long id, 
			@Valid @ModelAttribute("show") Show show, BindingResult result, HttpSession session) {
		Long userId = (Long)session.getAttribute("userId");
		if (userId == null)
			return "redirect:/";
		User user = userService.findUser(userId);
		if (user == null)
			return "redirect:/";
		if (result.hasErrors())
			return "editShow.jsp";
		showService.updateShow(id, show, result);
		if (result.hasErrors())
			return "editShow.jsp";
		return "redirect:/shows";	
	}
	
	@PostMapping("/shows/new")
	public String createShow(@Valid @ModelAttribute("show") Show show, BindingResult result,
			HttpSession session) {
		Long userId = (Long)session.getAttribute("userId");
		if (userId == null)
			return "redirect:/";
		User user = userService.findUser(userId);
		if (user == null)
			return "redirect:/";
		if (result.hasErrors())
			return "newShow.jsp";
		showService.createShow(show, result);
		if (result.hasErrors())
			return "newShow.jsp";
		return "redirect:/shows";
	}
	
	@PostMapping("/shows/create")
	public String getCreateShow(HttpSession session) {
		Long userId = (Long)session.getAttribute("userId");
		if (userId == null)
			return "redirect:/";
		User user = userService.findUser(userId);
		if (user == null)
			return "redirect:/";
		return "redirect:/shows/new";
	}
	
	@PostMapping("/shows/cancel")
	public String cancel(HttpSession session) {
		Long userId = (Long)session.getAttribute("userId");
		if (userId == null)
			return "redirect:/";
		User user = userService.findUser(userId);
		if (user == null)
			return "redirect:/";
		return "redirect:/shows";
	}
	
	@PostMapping("/shows/delete/{showId}")
	public String destroy(@PathVariable("showId") Long showId, HttpSession session) {
		Long userId = (Long)session.getAttribute("userId");
		if (userId == null)
			return "redirect:/";
		User user = userService.findUser(userId);
		if (user == null)
			return "redirect:/";
		showService.deleteShow(showId);
		return "redirect:/shows";
	} 
	
	@PostMapping("/shows/addRating/{showId}")
	public String addRating(@PathVariable("showId") Long showId, @Valid @ModelAttribute("rating") Rating rating, 
			BindingResult result, HttpSession session) {
		Long userId = (Long)session.getAttribute("userId");
		if (userId == null)
			return "redirect:/";
		User user = userService.findUser(userId);
		if (user == null)
			return "redirect:/";
		if (result.hasErrors())
			return "show.jsp";
		
		System.out.println("curUserId " + user.getId());
		Show show = showService.findShow(showId);
		
		System.out.println("rating value:  " + rating.getValue());
		System.out.printf("show title:  %s, show id:  %d\n", rating.getShow().getTitle(), rating.getShow().getId());
		System.out.printf("user name:  %s, user id:  %d\n", rating.getUser().getName(), rating.getUser().getId());
		
		System.out.printf("number of user ratings: %d\n", user.getRatedShows().size());
		System.out.printf("number of show ratings: %d\n", show.getRatedShows().size());
		
	//	userService.addRating(userId, rating);
	//	showService.addRating(showId, rating);
		ratingService.createRating(rating);
		
		System.out.printf("number of user ratings: %d\n", user.getRatedShows().size());
		System.out.printf("number of show ratings: %d\n", show.getRatedShows().size());

	
		return "redirect:/shows/" + showId;
	}
}
