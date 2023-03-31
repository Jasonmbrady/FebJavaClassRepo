package com.jasonb.apizza.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jasonb.apizza.models.User;
import com.jasonb.apizza.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	public User save(User u) {
		return userRepo.save(u);
	}
	
	public User findByEmail(String email) {
		Optional<User> optUser = userRepo.findByEmail(email);
		if (optUser.isPresent()) {
			return optUser.get();
		}
		return null;
	}
}
