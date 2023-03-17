package com.jasonb.flashexperiment.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jasonb.flashexperiment.models.LoginUser;
import com.jasonb.flashexperiment.models.User;
import com.jasonb.flashexperiment.services.UserService;

@Controller
public class HomeController {
	@Autowired
	private UserService userServ;

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("loginUser", new LoginUser());
		model.addAttribute("user", new User());
		return "index.jsp";
	}
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("loginUser") LoginUser loginUser, BindingResult result, HttpSession session, Model model) {
		User loggedUser =
		if (result.hasErrors()) {
			
		}
		
		return "redirect:/dashboard";
	}
	
	@PostMapping("/register")
	public String register() {
		return "redirect:/dashboard";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/dashboard")
	public String dashboard() {
		return "dashboard.jsp";
	}
}
