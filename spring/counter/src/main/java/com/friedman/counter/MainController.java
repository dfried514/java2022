package com.friedman.counter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/your_server")
public class MainController {

	@RequestMapping("")
	public String index(Model model) {
		model.addAttribute("name", "David");
		return "index.jsp";
	}
}
