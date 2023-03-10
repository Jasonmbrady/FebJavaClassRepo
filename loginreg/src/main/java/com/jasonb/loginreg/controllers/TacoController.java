package com.jasonb.loginreg.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jasonb.loginreg.models.Taco;
import com.jasonb.loginreg.services.TacoService;
import com.jasonb.loginreg.services.UserService;

@Controller
@RequestMapping("/taco")
public class TacoController {
	@Autowired
	private UserService userServ;
	@Autowired
	private TacoService tacoServ;
	
	@GetMapping("/new")
	public String newTaco(@ModelAttribute("taco") Taco taco, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		return "newTaco.jsp";
	}
	
	@PostMapping("/new")
	public String createTaco(@Valid @ModelAttribute("taco") Taco taco, BindingResult result, HttpSession session) {
		if (result.hasErrors()) {
			return "newTaco.jsp";
		}
		Long userId = (Long) session.getAttribute("userId");
		taco.setSubmittedBy(userServ.findById(userId));
		tacoServ.save(taco);
		return "redirect:/dashboard";
	}

}
