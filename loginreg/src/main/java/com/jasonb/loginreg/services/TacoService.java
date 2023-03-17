package com.jasonb.loginreg.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jasonb.loginreg.models.Taco;
import com.jasonb.loginreg.repositories.TacoRepository;

@Service
public class TacoService {
	@Autowired
	private TacoRepository tacoRepo;

	public Taco save(Taco t) {
		return tacoRepo.save(t);
	}
	
	public Taco findById(Long id) {
		Optional<Taco> optTaco = tacoRepo.findById(id);
		if (optTaco.isEmpty()){
			return null;
		} else {
			return optTaco.get();
		}
	}
	
	public List<Taco> findAll(){
		return tacoRepo.findAll();
	}
}
