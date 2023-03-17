package com.jasonb.loginreg.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jasonb.loginreg.models.Topping;
import com.jasonb.loginreg.repositories.ToppingRepository;

@Service
public class ToppingService {

	@Autowired
	private ToppingRepository toppingRepo;
	
	public List<Topping> findAll(){
		return toppingRepo.findAll();
	}
	
	public Topping findById(Long id) {
		Optional<Topping> optTop = toppingRepo.findById(id);
		if (optTop.isEmpty()) {
			return null;
		} else {
			return optTop.get();
		}
	}
	
	public Topping save(Topping t) {
		return toppingRepo.save(t);
	}
}
