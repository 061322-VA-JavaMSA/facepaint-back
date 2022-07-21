package com.revature.facepaint.services;

import org.springframework.stereotype.Service;

@Service
public class UserService {

	private UserRepository ur;
	
	public UserService(UserRepository ur) {
		super();
		this.ur = ur;
	}
	
	public void setImageToUserShowcase(String username, int imageID) {
		
	}
}
