package com.jasonb.luricslab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jasonb.luricslab.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;
}
