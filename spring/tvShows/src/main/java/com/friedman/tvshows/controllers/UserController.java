package com.friedman.tvshows.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.friedman.tvshows.models.LoginUser;
import com.friedman.tvshows.models.User;
import com.friedman.tvshows.services.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String index(Model model) {
		// Bind empty User and LoginUser objects to the JSP
		// to capture the form input
	    model.addAttribute("newUser", new User());
	    model.addAttribute("newLogin", new LoginUser());
	    return "index.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, 
			BindingResult result, Model model, HttpSession session) {
	     
		User user = userService.register(newUser, result);
	    if(result.hasErrors()) {
	    	// Be sure to send in the empty LoginUser before 
	        // re-rendering the page.
	        model.addAttribute("newLogin", new LoginUser());
	        return "index.jsp";
	    }
	    session.setAttribute("userId", user.getId());
	    return "redirect:/shows";
	}
	 
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
			BindingResult result, Model model, HttpSession session) {
	     
		User user = userService.login(newLogin, result);
	 
	    if(result.hasErrors() || user == null) {
	    	model.addAttribute("newUser", new User());
	    	return "index.jsp";
	    }
	 
	    // No errors! 
	    // TO-DO Later: Store their ID from the DB in session, 
	    // in other words, log them in.
	    session.setAttribute("userId", user.getId());
	    return "redirect:/shows";
	}
	 
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("userId");
		return "redirect:/";
	}
}
