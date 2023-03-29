package com.jasonb.apizza.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jasonb.apizza.models.Pizza;
import com.jasonb.apizza.services.PizzaService;

@RestController
public class HomeController {
	@Autowired
	private PizzaService pizzaServ;

	@GetMapping("/")
	public String index() {
		return "{'greeting': 'Hello, World', 'frequency': 10}";
	}
	
	@GetMapping("/api/{id}")
	public Pizza getOnePizza(@PathVariable("id") Long id) {
		return pizzaServ.findById(id);
	}
	
	@PostMapping("/api/new")
	public Pizza createPizza(@RequestBody Pizza newPizza){
		return pizzaServ.save(newPizza);
	}
	
	@PutMapping("/api/{id}")
	public Pizza updatePizza(@RequestBody Pizza updatedPizza, @PathVariable("id") Long id) {
		updatedPizza.setId(id);
		return pizzaServ.save(updatedPizza);
	}
	
	@DeleteMapping("api/{id}")
	public String deletePizza(@PathVariable("id") Long id) {
		Pizza pizza = pizzaServ.findById(id);
		if (pizza == null) {
			return "Pizza not found. Nothing deleted";
		} else {
			pizzaServ.delete(id);
			return "Pizza with " + pizza.getToppings() + "deleted!";
		}
	}
}
