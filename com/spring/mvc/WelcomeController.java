package com.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WelcomeController {

	@GetMapping("/welcome")
	public String welcomeMethod() {
		System.out.println("Welcome . . . ");
		
		return "welcome";
	}// /WEB-INF/views/welcome.jsp
	
	@PostMapping("/welcome")
	public String welcomePost() {
		System.out.println("Welcome post. . . ");
		
		return "welcome";
	}
}
