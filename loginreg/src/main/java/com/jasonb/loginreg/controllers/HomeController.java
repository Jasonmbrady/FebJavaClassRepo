package com.jasonb.loginreg.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jasonb.loginreg.models.LoginUser;
import com.jasonb.loginreg.models.User;
import com.jasonb.loginreg.services.TacoService;
import com.jasonb.loginreg.services.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userServ;
	@Autowired
	private TacoService tacoServ;
	
	@GetMapping("/")
	public String index(Model model, HttpServletRequest request) {
		model.addAttribute("user", new User());
		model.addAttribute("loginUser", new LoginUser());
		return "index.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {
		// run register method
		User newUser = userServ.register(user, result);
		if(newUser == null) {
			model.addAttribute("loginUser", new LoginUser());
			return "index.jsp";
		}
		// add user to DB
		// log user in
		session.setAttribute("userId", newUser.getId());
		return "redirect:/dashboard";
	}
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("loginUser") LoginUser loginUser, BindingResult result, Model model, HttpSession session) {
		//run login method
		User user = userServ.login(loginUser, result);
		if (user == null) {
			model.addAttribute("user", new User());
			return "index.jsp";
		}
		session.setAttribute("userId", user.getId());
		return "redirect:/dashboard";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(Model model, HttpSession session, RedirectAttributes redirect) {
		if (session.getAttribute("userId") == null) {
			redirect.addFlashAttribute("error", "You must be logged in to do that!");
			return "redirect:/";
		}
		Long id = (Long) session.getAttribute("userId");
		User loggedUser = userServ.findById(id);
		model.addAttribute("allTacos", tacoServ.findAll());
		model.addAttribute("user", loggedUser);
		return "dashboard.jsp";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("userId", null);
		return "redirect:/";
	}

}
