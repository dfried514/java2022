package com.friedman.daikichi;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")
public class DaikichiController {
	//Annotation
	@RequestMapping("")
	//method that maps to the request route above
	public String welcome() {
		return "Welcome!";
	}
	@RequestMapping("/today")
	public String today() {
		return "Today, you will find luck in all your endeavors!";
	}
	@RequestMapping("/tomorrow")
	public String tomorrow() {
		return "Tomorrow, a new opportunity will arise, so be sure to be open to new ideas!";
	}
	@RequestMapping("travel/{city}")
	public String travel(@PathVariable("city") String city) {
		return "Congratulations! You will soon travel to " + city + "!";
	}
	@RequestMapping("/lotto/{number}")
	public String lotto(@PathVariable("number") String number) {
		if (Integer.parseInt(number) % 2 == 0) 
			return "You will take a grand journey in the near future, but be wary of tempting offers.";
		return "You have enjoyed the fruits of your labor, but now is a great time to spend with family and friends.";
	}	
}
