package com.jasonb.loginreg.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jasonb.loginreg.models.Comment;
import com.jasonb.loginreg.models.Taco;
import com.jasonb.loginreg.models.Topping;
import com.jasonb.loginreg.services.CommentService;
import com.jasonb.loginreg.services.TacoService;
import com.jasonb.loginreg.services.ToppingService;
import com.jasonb.loginreg.services.UserService;

@Controller
@RequestMapping("/taco")
public class TacoController {
	@Autowired
	private UserService userServ;
	@Autowired
	private TacoService tacoServ;
	@Autowired
	private ToppingService toppingServ;
	@Autowired
	private CommentService commentServ;
	
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
	
	@GetMapping("/{id}")
	public String viewTaco(Model model, HttpSession session, @PathVariable("id") Long id, RedirectAttributes redirect) {
		if (session.getAttribute("userId") == null) {
			redirect.addFlashAttribute("error", "You must be logged in to do that!");
			return "redirect:/";
		}
		Taco taco = tacoServ.findById(id);
		model.addAttribute("comment", new Comment());
		model.addAttribute("allToppings", toppingServ.findAll());
		model.addAttribute("taco", taco);
		return "viewTaco.jsp";
	}
	
	@PutMapping("/{id}")
	public String updateTaco(@PathVariable("id") Long id, @RequestParam(name="toppings") Long toppingId) {
		Topping topping = toppingServ.findById(toppingId);
		Taco taco = tacoServ.findById(id);
		List<Topping> topList = taco.getToppings();
		topList.add(topping);
		taco.setToppings(topList);
		tacoServ.save(taco);
		return "redirect:/taco/" + id;
	}
	
	@PostMapping("/{tacoId}/newComment")
	public String addComment(@Valid @ModelAttribute("comment") Comment comment, BindingResult result, @PathVariable("tacoId") Long tacoId, HttpSession session) {
		comment.setTaco(tacoServ.findById(tacoId));
		comment.setCommenter(userServ.findById((Long) session.getAttribute("userId")));
		commentServ.save(comment);
//		User user = userServ.findById((Long) session.getAttribute("userId"));
//		Taco taco = tacoServ.findById(tacoId);
//		List<Comment> userComments = user.getComments();
//		List<Comment> tacoComments = taco.getComments();
//		userComments.add(comment);
//		tacoComments.add(comment);
//		user.setComments(userComments);
//		taco.setComments(tacoComments);
//		userServ.save(user);
//		tacoServ.save(taco);
		return "redirect:/taco/" + tacoId;
	}
	
	@PostMapping("/{tacoId}/removeTopping")
	public String removeTopping(@RequestParam(name="toppingId") Long toppingId, @PathVariable("tacoId") Long tacoId) {
		Taco taco = tacoServ.findById(tacoId);
		Topping topping = toppingServ.findById(toppingId);
		List<Taco> tacoList = topping.getTacos();
		tacoList.remove(taco);
		topping.setTacos(tacoList);
		toppingServ.save(topping);
		return "redirect:/taco/" + tacoId;
	}

	@GetMapping("/{id}/removeComment")
	public String removeComment(@PathVariable("id")Long id) {
		commentServ.delete(id);
		return "redirect:/dashboard"; 
	}
}
