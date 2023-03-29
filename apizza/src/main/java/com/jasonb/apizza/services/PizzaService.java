package com.jasonb.apizza.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jasonb.apizza.models.Pizza;
import com.jasonb.apizza.repositories.PizzaRepository;

@Service
public class PizzaService {

	@Autowired
	private PizzaRepository pizzaRepo;
	
	public Pizza save(Pizza p) {
		return pizzaRepo.save(p);
	}
	
	public Pizza findById(Long id) {
		Optional<Pizza> optPizza = pizzaRepo.findById(id);
		if (optPizza.isEmpty()) {
			return null;
		} else {
			return optPizza.get();
		}
	}
	
	public void delete(Long id) {
		pizzaRepo.deleteById(id);
	}
}
