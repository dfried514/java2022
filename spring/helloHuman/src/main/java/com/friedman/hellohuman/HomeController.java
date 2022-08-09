package com.friedman.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HomeController {
    @RequestMapping("/")
    public String index(@RequestParam(value="name", required=false) String nameQuery,
    		@RequestParam(value="last_name", required=false) String lastNameQuery,
    		@RequestParam(value="times", required=false) String timesQuery) {
    	String fName = nameQuery != null ? nameQuery : "Human";
    	String lName = lastNameQuery != null ? lastNameQuery : "";
    	int count = timesQuery != null ? Integer.parseInt(timesQuery) : 1;
    	String greeting = "Hello " + fName + " " + lName;
    	
    	for (int i = 2; i <= count; i++) {
    		greeting += " Hello " + fName + " " + lName;
    	}
        return greeting;
    }
}

