package com.friedman.hoppersreceipt;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("name", "Grace Hopper");
		model.addAttribute("itemName", "Copper Wire");
		model.addAttribute("price", 5.25);
		model.addAttribute("description", "Metal strips, also an illustration of nanoseconds.");
		model.addAttribute("vendor", "Little Things Corner Store");
		return "index.jsp";
	}
}
