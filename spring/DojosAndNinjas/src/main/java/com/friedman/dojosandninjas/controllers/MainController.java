package com.friedman.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.friedman.dojosandninjas.models.Dojo;
import com.friedman.dojosandninjas.models.Ninja;
import com.friedman.dojosandninjas.services.DojoService;
import com.friedman.dojosandninjas.services.NinjaService;

@Controller
public class MainController {
	
	@Autowired 
	DojoService dojoService;
	
	@Autowired
	NinjaService ninjaService;
	
	
	@GetMapping("/")
	public String index(Model model) {
		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojos", dojos);
		return "index.jsp";
	}
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "newDojo.jsp";
	}
	@GetMapping("/ninjas/new")
	public String newNinja(Model model, @ModelAttribute("ninja") Ninja ninja) {
		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojos", dojos);
		return "newNinja.jsp";
	}
	@GetMapping("/dojos/{id}")
	public String getDojo(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojoService.findDojo(id);
		model.addAttribute("dojo", dojo);
		return "dojo.jsp";
	}
	@PostMapping("/getDojo") 
	public String getDojo(Model model, @RequestParam(value="dojo") Long id) {
		Dojo dojo = dojoService.findDojo(id);
		model.addAttribute("dojo", dojo);
		return "dojo.jsp";
	}
	@PostMapping("/ninjas/new")
	public String createNinja(Model model, @Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if (result.hasErrors())
			return "newNinja.jsp";
		ninjaService.createNinja(ninja);
		return "redirect:/";
	}
	@PostMapping("/dojos/new")
	public String createDojo(Model model, @Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) 
			return "newDojo.jsp";
		dojoService.createDojo(dojo);
		return "redirect:/";
	}
}
