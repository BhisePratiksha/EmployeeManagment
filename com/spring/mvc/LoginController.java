package com.spring.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String login() {
		
		return "login";
	}
	
	@PostMapping("/login")
	public String loginPost(HttpServletRequest request, Model model) {
		String name = request.getParameter("name");
		String pwd = request.getParameter("password");
		System.out.println("Name:"+name +", Password:"+pwd);
		if(name.equalsIgnoreCase("user1")) {
			model.addAttribute("name", name);
			return "redirect:/welcome";
		}
		model.addAttribute("message", "Wrong username/password provided.");
		
		return "login";
	}
}
