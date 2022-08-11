package com.friedman.omikuji;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/omikuji")
public class MainController {

	@RequestMapping("")
	public String index() {
		return "index.jsp";
	}
	
	@PostMapping("/processForm")
	public String processForm(
	    @RequestParam(value="luckyNumber") Integer luckyNumber,
	    @RequestParam(value="city") String city, 
	    @RequestParam(value="person") String person,
	    @RequestParam(value="hobby") String hobby,
	    @RequestParam(value="livingType") String livingType,
	    @RequestParam(value="message") String message,
	    HttpSession session) {
		
		session.setAttribute("luckyNumber", luckyNumber);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("hobby", hobby);
		session.setAttribute("livingType", livingType);
		session.setAttribute("message", message);
	    
	    return "redirect:/omikuji/show";
	}
  
	@RequestMapping("/show")
	public String show(HttpSession session, Model model) {
		Integer luckyNumber = (Integer) session.getAttribute("luckyNumber");
		String city = (String) session.getAttribute("city");
		String person = (String) session.getAttribute("person");
		String hobby = (String) session.getAttribute("hobby");
		String livingType = (String) session.getAttribute("lvingType");
		String message = (String) session.getAttribute("message");
		
		model.addAttribute("luckyNumber", luckyNumber);
		model.addAttribute("city", city);
		model.addAttribute("person", person);
		model.addAttribute("hobby", hobby);
		model.addAttribute("lvingType", livingType);
		model.addAttribute("message", message);
		
		return "show.jsp";
	}
}
