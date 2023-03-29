package com.jasonb.luricslab.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jasonb.luricslab.models.LoginUser;
import com.jasonb.luricslab.models.Song;
import com.jasonb.luricslab.models.User;
import com.jasonb.luricslab.services.SongService;
import com.jasonb.luricslab.services.UserService;

@Controller
public class HomeController {
	@Autowired
	private UserService userServ;
	@Autowired
	private SongService songServ;

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("loginUser", new LoginUser());
		return "index.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session, Model model) {
		User newUser = userServ.register(user, result);
		if (newUser == null) {
			model.addAttribute("loginUser", new LoginUser());
			return "index.jsp";
		}
		session.setAttribute("userId", newUser.getId());
		return "redirect:/home";
	}
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("loginUser") LoginUser loginUser, BindingResult result, HttpSession session, Model model) {
		User logUser = userServ.login(loginUser, result);
		if (logUser == null) {
			model.addAttribute("user", new User());
			return "index.jsp";
		}
		session.setAttribute("userId", logUser.getId());
		return "redirect:/home";
	}
	
	@GetMapping("/home")
	public String home(HttpSession session, Model model) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		List<Song> allSongs = songServ.findAll();
		for (Song oneSong : allSongs) {
			ArrayList<User> collaborators = new ArrayList<User>();
			for(User oneUser : oneSong.getCollaborators()) {
				if (!collaborators.contains(oneUser)) {
					collaborators.add(oneUser);
				}
			}
			oneSong.setNumCollaborators(collaborators.size());
		}
		model.addAttribute("user", userServ.findById((Long) session.getAttribute("userId")));
		model.addAttribute("allSongs", allSongs);
		return "home.jsp";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
