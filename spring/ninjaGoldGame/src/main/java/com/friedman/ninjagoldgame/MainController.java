package com.friedman.ninjagoldgame;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/Gold")
public class MainController {

	@RequestMapping("")
	public String index(HttpSession session) {
		if (session.getAttribute("gold") == null) 
			session.setAttribute("gold", 0);
		
		if (session.getAttribute("activities") == null)
			session.setAttribute("activities", new ArrayList<Activity>());
		
		if ((Integer)session.getAttribute("gold") < -50)
			return "debtorsPrison.jsp";
	
		return "index.jsp";
	}
	
	@PostMapping("/processForm")
	public String processForm(
	    @RequestParam(value="farm", required = false) String farm,
	    @RequestParam(value="cave", required = false) String cave, 
	    @RequestParam(value="house", required = false) String house,
	    @RequestParam(value="spa", required = false) String spa,
	    @RequestParam(value="quest", required = false) String quest,
	    HttpSession session) {
		
		Random random = new Random();
		int randomGold = 0;
		String location = "";
		
		if (farm != null) {
			randomGold = random.nextInt(11) + 10;
			location = "farm";
		} 
		if (cave != null) {
			randomGold = random.nextInt(6) + 5;
			location = "cave";
		}
		if (house != null) {
			randomGold = random.nextInt(4) + 2;
			location = "house";
		} 
		if (spa != null) {
			randomGold = (random.nextInt(16) + 5);
			randomGold = -randomGold;
			location = "spa";
		} 
		if (quest != null) {
			randomGold = random.nextInt(51);
			boolean posNeg = random.nextBoolean();
			randomGold = posNeg ? randomGold : -randomGold;
			location = "quest";
		} 
		
		session.setAttribute("gold", (Integer)session.getAttribute("gold") + randomGold);
		
		ArrayList<Activity> activities = (ArrayList<Activity>) session.getAttribute("activities");
		
		activities.add(new Activity(location, randomGold, new Date()));
		session.setAttribute("activities", activities);
		
	    return "redirect:/Gold";
	}
	
	@PostMapping("/reset")
	public String reset(HttpSession session) {
		session.setAttribute("gold", 0);
		
		ArrayList<Activity> activities = (ArrayList<Activity>) session.getAttribute("activities");
		activities.clear();
		session.setAttribute("activities", activities);
		
		return "redirect:/Gold";
	}
}
