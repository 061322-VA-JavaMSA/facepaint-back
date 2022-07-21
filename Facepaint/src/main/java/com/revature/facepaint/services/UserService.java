package com.revature.facepaint.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.facepaint.models.User;
import com.revature.facepaint.repositories.UserRepository;

@Service
public class UserService {

	private UserRepository ur;
	
	@Autowired
	public UserService(UserRepository ur) {
		super();
		this.ur = ur;
	}
	
	/*
	 *	/users
	 *	post - create user on db
	 *
	 *	/users/{id}
	 *	delete- remove user from db
	 */
	public List<User> getUsers(){
		return ur.findAll();
	} 
	 
	public User  addUser(User user) {
		 
		return ur.save(user);
	}
	
	public User removeUserById(User u) {
		ur.delete(u);
		
		return null ;
	}

}
