package com.jasonb.apizza.controllers;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jasonb.apizza.models.LoginUser;
import com.jasonb.apizza.models.Pizza;
import com.jasonb.apizza.models.User;
import com.jasonb.apizza.services.PizzaService;
import com.jasonb.apizza.services.UserService;

@CrossOrigin
@RestController
public class HomeController {
	@Autowired
	private PizzaService pizzaServ;
	@Autowired
	private UserService userServ;

	@GetMapping("/")
	public String index() {
		return "{'greeting': 'Hello, World', 'frequency': 10}";
	}
	
	@GetMapping("/api/{id}")
	public Pizza getOnePizza(@PathVariable("id") Long id) {
		return pizzaServ.findById(id);
	}
	
	@GetMapping("/api/all")
	public List<Pizza> getAll(){
		return pizzaServ.findAll();
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
	
	@PostMapping("/api/register")
	public User createUser(@RequestBody User user) {
		String pw = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(pw);
		User newuser = userServ.save(user);
		newuser.setPassword(null);
		return newuser;
	}
	
	@PostMapping("/api/login")
	public User loginUser(@RequestBody LoginUser loginUser) {
		User loggedUser = userServ.findByEmail(loginUser.getEmail());
		if (!BCrypt.checkpw(loginUser.getPassword(), loggedUser.getPassword())){
			return null;
		}
		return loggedUser;
	}
}
