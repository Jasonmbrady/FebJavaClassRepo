package com.jasonb.loginreg.services;

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
}
