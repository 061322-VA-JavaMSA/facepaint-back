package com.revature.facepaint.services;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.revature.facepaint.model.User;
import com.revature.facepaint.repositories.UserRepository;

@Service
@Transactional
public class UserService {

	private UserRepository ur;
	
	public UserService(UserRepository ur) {
		super();
		this.ur = ur;
	}
	
	public void setImageToUserShowcase(String username, int imageID) {
		
	}
}
