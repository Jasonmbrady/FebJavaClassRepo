package com.jasonb.luricslab.services;

import java.util.Optional;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.jasonb.luricslab.models.LoginUser;
import com.jasonb.luricslab.models.User;
import com.jasonb.luricslab.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;
	
	public User findById(Long id) {
		Optional<User> optUser = userRepo.findById(id);
		if (optUser.isEmpty()) {
			return null;
		} else {
			return optUser.get();
		}
	}
	
	public User register(User u, BindingResult result) {
		if (!u.getPassword().equals(u.getConfirmPass())) {
			result.rejectValue("confirmPass", null, "Password and Confirm Password must match!");
		}
		if (result.hasErrors()) {
			return null;
		}
		String hashPW = BCrypt.hashpw(u.getPassword(), BCrypt.gensalt());
		u.setPassword(hashPW);
		return userRepo.save(u);
	}
	
	public User login(LoginUser l, BindingResult result) {
		Optional<User> optUser = userRepo.findByEmail(l.getEmail());
		if (optUser.isEmpty() || !BCrypt.checkpw(l.getPassword(), optUser.get().getPassword())) {
			result.rejectValue("email", null, "Invalid Username and/or Password!");
		}
		if (result.hasErrors()) {
			return null;
		}
		return optUser.get();
	}
}
