package com.friedman.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/your_server")
public class MainController {

	@RequestMapping("")
	public String index(HttpSession session, Model model) {
		if (session.getAttribute("count") == null)
			session.setAttribute("count", 0);
		else 
			session.setAttribute("count", (Integer) session.getAttribute("count") + 1);
		
		model.addAttribute("count", (Integer) session.getAttribute("count"));
		
		return "index.jsp";
	}
	
	@RequestMapping("/counter")
	public String count() {
		return "counter.jsp";
	}
	
	@RequestMapping("/conter2")
	public String count2(HttpSession session, Model model) {
		session.setAttribute("count", (Integer) session.getAttribute("count") + 2);
		
		model.addAttribute("count", (Integer) session.getAttribute("count"));
		return "conter2.jsp";
	}
	
	@RequestMapping("/reset") 
	public String reset(HttpSession session) {
		session.setAttribute("count", null);
		return "redirect:/your_server";
	}
}
