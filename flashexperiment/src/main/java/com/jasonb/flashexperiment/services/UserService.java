package com.jasonb.flashexperiment.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.jasonb.flashexperiment.models.LoginUser;
import com.jasonb.flashexperiment.models.User;
import com.jasonb.flashexperiment.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	public List<User> findAll(){
		return userRepo.findAll();
	}
	
	public User save(User u) {
		return userRepo.save(u);
	}
	
	public User findById(Long id) {
		Optional<User> optUser = userRepo.findById(id);
		if (optUser.isEmpty()) {
			return null;
		} else {
			return optUser.get();
		}
	}
	
	public User login(LoginUser logUser, BindingResult result) {
		Optional<User> optUser = userRepo.findByEmail(logUser.getEmail());
		if (optUser.isEmpty() || !BCrypt.checkpw(logUser.getEmail(), optUser.get().getPassword())) {
			result.rejectValue("email", null, "Invalid Username and/or Password!");
			return null;
		} else {
			return optUser.get();
		}
	}
	
	public User register(User user, BindingResult result) {
		
	}
}
