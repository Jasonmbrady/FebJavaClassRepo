package com.jasonb.first.contollers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String index(Model model, HttpSession session) {
		if (session.getAttribute("fruitList") == null) {
			session.setAttribute("fruitList", new ArrayList<String>());
		}
		if (session.getAttribute("priceList") == null) {
			session.setAttribute("priceList", new ArrayList<Double>());
		}
		
		ArrayList<String> fruitList = (ArrayList<String>) session.getAttribute("fruitList");
		ArrayList<Double> priceList = (ArrayList<Double>) session.getAttribute("priceList");
//		ArrayList<String> fruitList = new ArrayList<String>();
//		fruitList.add("Banana");
//		fruitList.add("Apple");
//		fruitList.add("Orange");
//		fruitList.add("Strawberry");
//		fruitList.add("Plum");
		model.addAttribute("fruitList", fruitList);
		model.addAttribute("priceList", priceList);
		return "index.jsp";
	}
	
	@GetMapping("/greet/{name}")
	public String greet(@PathVariable("name") String name, Model model) {
		model.addAttribute("name", name);
		return "greet.jsp";
	}
	
	@GetMapping("/form")
	public String form() {
		return "form.jsp";
	}
	
	@PostMapping("/form")
	public String processForm(@RequestParam(value="name") String name, @RequestParam(value="price") Double price, HttpSession session) {
		// process form
		// take data from the form, store it in session as ArrayLists price name
		
		ArrayList<String> fruitList = (ArrayList<String>) session.getAttribute("fruitList");
		fruitList.add(name);
		session.setAttribute("fruitList", fruitList);
		
		ArrayList<Double> priceList = (ArrayList<Double>) session.getAttribute("priceList");
		priceList.add(price);
		session.setAttribute("priceList", priceList);

		
		return "redirect:/macaroni";
	}
	

}
