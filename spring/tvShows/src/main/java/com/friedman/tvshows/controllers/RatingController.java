package com.friedman.tvshows.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.friedman.tvshows.models.Show;
import com.friedman.tvshows.models.User;

//@Controller
//public class RatingController {
//
//	@PostMapping("/shows/new")
//	public String createGame(@Valid @ModelAttribute("show") Show show, BindingResult result,
//			HttpSession session) {
//		Long userId = (Long)session.getAttribute("userId");
//		if (userId == null)
//			return "redirect:/";
//		User user = userService.findUser(userId);
//		if (user == null)
//			return "redirect:/";
//		if (result.hasErrors())
//			return "newShow.jsp";
//		showService.createShow(show, result);
//		if (result.hasErrors())
//			return "newShow.jsp";
//		return "redirect:/shows";
//	}
//}
