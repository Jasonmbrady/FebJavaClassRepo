package com.jasonb.flashexperiment.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class LoginUser {

	@NotEmpty(message="Please enter a valid email address")
	@Email(message="Please enter a valid email address")
	private String email;
	@NotEmpty(message="Password is required")
	private String password;
	
	public LoginUser() {}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	};
	
	
}
